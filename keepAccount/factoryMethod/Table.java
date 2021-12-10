package keepAccount.factoryMethod;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Table {
    protected Object[] books;
    protected ArrayList<Map> dataSet = new ArrayList<Map>();
    protected String table;
    
    protected void setup(Object ... objs) {
        this.books = objs;
        for (Object o : objs) {
            this.dataSet.add(parse(o));
        }
        this.table = format();
    }
    
    protected Map parse(Object obj) {
        Map<String, String> data = new HashMap<String, String>();
        
        for (Field field : obj.getClass().getDeclaredFields()) {
            
            try {
                field.setAccessible(true);
                data.put(field.getName(), field.get(obj).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
        return data;
    }
    
    public void show() {
        System.out.println(this.table);
    }
    
    protected String getFilePath(String fileName) {
        Path filePath = Paths.get(fileName);
        Path AbsPath = filePath.toAbsolutePath();
        
        return AbsPath.toString();
    }
    
    protected abstract String format();
    public abstract String dumpFile(String fileTitle);
}
