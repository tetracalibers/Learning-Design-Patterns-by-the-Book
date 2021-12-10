package keepAccount.templateMethod;

import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

public class MakeXMLFile extends AbstractMakeFile {
    public MakeXMLFile(Object ... objs) {
        setup(objs);
    }
    
    @Override
    public String writeStart() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<root>\n" + "\t<bookShelf>\n";
    }
    
    @Override
    public String format(Map data) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t\t<book>\n");
        for (Object key: data.keySet()) {
            sb.append("\t\t\t<" + key + ">" + data.get(key) + "</" + key + ">\n");
        }
        sb.append("\t\t</book>\n");
        
        return sb.toString();
    }
    
    @Override
    public String writeEnd() {
        return "\t</bookShelf>\n" + "</root>";
    }
}
