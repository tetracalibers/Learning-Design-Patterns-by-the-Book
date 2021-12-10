package keepAccount.templateMethod;

import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

public class MakeJSONFile extends AbstractMakeFile {
    private int objsCount = 0;
    
    public MakeJSONFile(Object ... objs) {
        setup(objs);
        this.objsCount = objs.length;
    }
    
    @Override
    public String writeStart() {
        return "[\n";
    }
    
    @Override
    public String format(Map data) {
        StringBuilder sb = new StringBuilder();
        int i = data.size();
        
        sb.append("\t{\n");
        for (Object key: data.keySet()) {
            sb.append("\t\t\"" + key + "\": \"" + data.get(key) + "\"");
            i--;
            if (i == 0) {
                sb.append("\n");
            } else {
                sb.append(",\n");
            }
        }
        sb.append("\t}");
        
        this.objsCount--;
        if (this.objsCount == 0) {
            sb.append("\n");
        } else {
            sb.append(",\n");
        }
        
        return sb.toString();
    }
    
    @Override
    public String writeEnd() {
        return "]";
    }
}
