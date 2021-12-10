import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class OutmostDirectory extends Directory {
    private String dirName;
    
    public OutmostDirectory(Grouping grouping, String dirName) {
        super(grouping);
        this.dirName = dirName;
    }
    
    @Override
    protected Date setUpStart() {
        return null;
    }
    
    @Override
    protected Date setUpEnd() {
        return null;
    }
    
    @Override
    public void grouping() {
        
    }
    
    @Override
    public void makeDataSet(String houseroomPathStr) {
        Path houseroomPath = Paths.get(huideroomPathStr).toAbsolutePath();
        String newDirPathStr = houseroomPath.toString() + "/" + dirName;
        Path newDirPath = Paths.get(newDirPathStr);
        
        try {
            Files.createDirectories(newDirPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        grouping.makeDataSet(newDirPathStr);
    }
}
