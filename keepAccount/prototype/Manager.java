package keepAccount.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Manager {
    private Map<String, Category> categoryList = new HashMap<>();
    
    public void register(String name, Category prototype) {
        categoryList.put(name, prototype);
    }
    
    public Category create(String prototypeName) {
        Category c = categoryList.get(prototypeName);
        return c.createCopy();
    }
}