import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class YearlyDirectory extends Directory {
    private Calendar cld = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    private List<String> years = new ArrayList<>();
    
    public YearlyDirectory(Grouping grouping) {
        super(grouping);
    }
    
    @Override
    protected Date setUpStart() {
        String startYearStr = sdf.format(grouping.setUpStart());
        return sdf.parse(startYearStr);
    }
    
    @Override
    protected Date setUpEnd() {
        String endYearStr = sdf.format(grouping.setUpEnd());
        return sdf.parse(endYearStr);
    }
    
    @Override
    public void grouping() {
        Date start = setUpStart();
        Date end = setUpEnd();
        
        Date current = start;
        cld.setTime(current);
        while (current.compareTo(end) < 1) {
            years.add(std.format(current));
            cld.add(Calendar.YEAR, 1);
            current = cld.getTime();
        }
    }
    
    @Override
    public void makeDataSet(String houseroomPathStr) {        
        Path houseroomPath = Paths.get(houseroomPathStr).toAbsolutePath();
        
        for (String year : years) {
            String newDirPathStr = houseroomPath.toString() + "/" + year;
            Path newDirPath = Paths.get(newDirPathStr);
            
            try {
                Files.createDirectories(newDirPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // TODO
        grouping.makeDateSet(newDirPathStr);
        
    }
}
