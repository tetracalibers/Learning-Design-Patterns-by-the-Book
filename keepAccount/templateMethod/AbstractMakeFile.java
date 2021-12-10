package keepAccount.templateMethod;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMakeFile {
    protected ArrayList<Map> dataSet = new ArrayList<Map>();
    
    public abstract String writeStart();
    public abstract String format(Map data);
    public abstract String writeEnd();
    
    
    public final void makeFile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(writeStart());
            for (Map data : dataSet) {
                fw.write(format(data));
            }
            fw.write(writeEnd());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setup(Object[] objs) {
        for (Object o : objs) {
            this.dataSet.add(parse(o));
        }
    }
    
    public Map parse(Object obj) {
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
}
