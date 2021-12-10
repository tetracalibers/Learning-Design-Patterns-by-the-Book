package keepAccount.templateMethod;

import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

public class MakeYAMLFile extends AbstractMakeFile {
    public MakeYAMLFile(Object ... objs) {
        setup(objs);
    }
    
    @Override
    public String writeStart() {
        return "";
    }
    
    @Override
    public String format(Map data) {
        StringBuilder sb = new StringBuilder();
        
        sb.append('-').append('\n');
        for (Object key: data.keySet()) {
            sb.append(key + ": " + data.get(key)).append('\n');
        }
        
        return sb.toString();
    }
    
    @Override
    public String writeEnd() {
        return "";
    }
}
