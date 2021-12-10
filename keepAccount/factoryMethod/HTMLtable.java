package keepAccount.factoryMethod;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;

public class HTMLtable extends Table {
    
    HTMLtable(Object ... objs) {
        setup(objs);
    }
    
    @Override
    protected String format() {
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<String>(this.dataSet.get(1).keySet());
        
        sb.append("\t<table border=\"1\">\n");
        
        sb.append("\t\t<tr>\n");
        for (String key : keys) {
            sb.append("\t\t\t<th>" + key + "</th>\n");
        }
        sb.append("\t\t</tr>\n");
        
        for (Map data : this.dataSet) {
            sb.append("\t\t<tr>\n");
            for (String key : keys) {
                sb.append("\t\t\t<td>" + data.get(key) + "</td>\n");
            }
            sb.append("\t\t</tr>\n");
        }
        
        sb.append("\t</table>\n");
        
        return sb.toString();
    }
    
    @Override
    public String dumpFile(String fileTitle) {
        String fileName = fileTitle + ".html";
        
        try {
            FileWriter fw =  new FileWriter(fileName);
            fw.write("<!DOCTYPE html>\n");
            fw.write("<html>\n");
            fw.write("<head>\n");
            fw.write("\t<title>" + fileTitle + "</title>\n");
            fw.write("</head>\n");
            fw.write("<body>\n");
            fw.write(this.table);
            fw.write("</body>\n");
            fw.write("</html>\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return getFilePath(fileName);
    }
}
