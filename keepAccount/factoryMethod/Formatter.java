package keepAccount.factoryMethod;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Formatter {    
    protected ArrayList<String> languages = new ArrayList<String>(Arrays.asList("latex", "html", "sql", "vba"));
    
    public final Table create(String type) {
        String typeId = type.toLowerCase();
        if (!languages.contains(typeId)) {
            System.out.println("指定可能な言語は以下のいずれか");
            for (String language : languages) {
                System.out.println(language);
            }
        }
        Table table = createTable(typeId);
        return table;
    }
    
    protected abstract Table createTable(String typeId);
}
