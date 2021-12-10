package keepAccount.abstractFactory.factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public abstract class Document {
    protected String title;
    protected List<Record> content = new ArrayList<>();
    
    public Document(String title) {
        this.title = title;
    }
    
    public void add(Record record) {
        content.add(record);
    }
    
    public void dumpFile(String fileTitle) {
        String fileName = fileTitle + ".html";
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(makeHTML());
            fw.close();
            
            Desktop desktop = Desktop.getDesktop();
            File f = new File(getFilePath(fileName));
            desktop.open(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected String getFilePath(String fileName) {
        Path filePath = Paths.get(fileName);
        Path AbsPath = filePath.toAbsolutePath();
        
        return AbsPath.toString();
    }
    
    public abstract String makeHTML();
}
