package keepAccount.facade;

import keepAccount.flyweight.*;
import keepAccount.prototypeRe2.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MonthlyXMLmaker {
    
    private MonthlyXMLmaker() {
        
    }
    
    public static void make(int startYear, int startMonth, String csvFileName) {
        Calendar cld = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        
        String endStr = sdf.format(cld.getTime());
        String startStr = String.valueOf(startYear) + String.valueOf(startMonth);
        
        Date end = null;
        Date start = null;
        
        try {
            end = sdf.parse(endStr);
            start = sdf.parse(startStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        BookStackFactory factory = BookStackFactory.getInstance();
        Publisher publisher = new Publisher();
        CSVparser csvParser = new CSVparser(csvFileName);
        List<String> rows = csvParser.getRows();
        
        Date current = start;
        cld.setTime(current);
        while (current.compareTo(end) < 1) {
            int currentInt = Integer.valueOf(sdf.format(current));
            BookStack stack = factory.getBookStack(currentInt);
            publisher.archive(currentInt, new Book(stack.getDocument()));
            Manuscript publications = publisher.bookbinding(currentInt);
                        
            cld.add(Calendar.MONTH, 1);
                        
            for (String row : rows) {
                Map<String, String> rowHash = csvParser.rowMakeHash(row);
                if (Integer.valueOf(rowHash.get("購入年")) != cld.get(Calendar.YEAR) || Integer.valueOf(rowHash.get("購入月")) != cld.get(Calendar.MONTH)) {
                    continue;
                }
                stack.add(publications.order(csvParser.rowDivideCommas(row)));
            }
            stack.dumpFile(String.valueOf("facadeOutput/" + cld.get(Calendar.YEAR)));
            current = cld.getTime();
        }
    }
}