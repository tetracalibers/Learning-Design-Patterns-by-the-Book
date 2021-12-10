package keepAccount.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BookStackFactory {
    // 既に作ったBookStackのインスタンスを管理
    private Map<Integer, BookStack> library = new HashMap<>();
    // singletonパターン
    private static BookStackFactory singleton = new BookStackFactory();
    
    private BookStackFactory() {
        
    }
    
    public static BookStackFactory getInstance() {
        return singleton;
    }
    
    public BookStack getBookStack(int yearMonth) {
        BookStack bookStack = library.get(yearMonth);
        
        if (bookStack == null) {
            bookStack = new BookStack(yearMonth);
            library.put(yearMonth, bookStack);
        }
        
        return bookStack;
    }
}
