package keepAccount.templateMethod;

import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

public class MakeCSVFile extends AbstractMakeFile {
    
    public MakeCSVFile(Object ... objs) {
        setup(objs);
    }
    
    @Override
    public String writeStart() {
        return "";
    }
    
    @Override
    public String format(Map data) {
        StringBuilder sb = new StringBuilder();
        int i = data.size();
        
        for (Object key: data.keySet()) {
            sb.append(data.get(key));
            i--;
            if (i == 0) {
                sb.append("\n");
            } else {
                sb.append(", ");
            }
        }
        
        return sb.toString();
    }
    
    @Override
    public String writeEnd() {
        return "";
    }
}
