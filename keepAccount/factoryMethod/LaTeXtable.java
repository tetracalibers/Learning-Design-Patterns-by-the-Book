package keepAccount.factoryMethod;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;

public class LaTeXtable extends Table {
    
    LaTeXtable(Object ... objs) {
        setup(objs);
    }
    
    @Override 
    protected String format() {
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<String>(this.dataSet.get(1).keySet());
        
        sb.append("\\begin{tabular}");
        sb.append("{|");
        int i = keys.size();
        while (i > 0) {
            sb.append("c|");
            i--;
        }
        sb.append("}\n\\hline\n");
        
        i = keys.size();
        sb.append("\t");
        for (String key : keys) {
            sb.append(key);
            i--;
            if (i == 0) {
                sb.append("\\\\ \\hline\n");
            } else {
                sb.append(" & ");
            }
        }
        
        for (Map data : this.dataSet) {
            sb.append("\t");
            i = keys.size();
            
            for (Object key: data.keySet()) {
                sb.append(data.get(key));
                i--;
                if (i == 0) {
                    sb.append("\\\\ \\hline\n");
                } else {
                    sb.append(" & ");
                }
            }
        }
        
        sb.append("\\end{tabular}\n");
        
        return sb.toString();
    }
    
    @Override
    public String dumpFile(String fileTitle) {
        String fileName = fileTitle + ".tex";
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("\\documentclass[12pt,dvipdfmx]{jsarticle}\n");
            fw.write("\\begin{document}\n");
            fw.write(this.table);
            fw.write("\\end{document}");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return getFilePath(fileName);
    }
}