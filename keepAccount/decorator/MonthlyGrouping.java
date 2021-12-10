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

public class MonthlyGrouping {
    private int startYear;
    private int startMonth;
    private String csvFileName;
    private Calendar cld = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
    private Map<Integer, BookStack> stacks;
    
    public MonthlyGrouping(int startYear, int startMonth, String csvFileName) {
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.csvFileName = csvFileName;
        this.stacks = new HashMap<>();
    }
    
    @Override
    protected Date setUpStart() {
        String startStr = String.valueOf(startYear) + String.valueOf(startMonth);
        Date start = null;
        try {
            start = sdf.parse(startStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return start;
    }
    
    @Override
    protected Date setUpEnd() {
        String endStr = sdf.format(cld.getTime());
        Date end = null;
        try {
            end = sdf.parse(endStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return end;
    }
        
    @Override
    public void grouping() {        
        Date start = setUpStart();
        Date end = setUpEnd();
        
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
            stacks.put(currentInt, stack);
            current = cld.getTime();
        }
    }
    
    @Override
    public void makeDataSet(String houseroomPathStr) {
        for (Object key: stacks.keySet()) {
            pathStrs.add(stacks.get(key).dumpFile(houseroomPathStr));
        }
    }
}
