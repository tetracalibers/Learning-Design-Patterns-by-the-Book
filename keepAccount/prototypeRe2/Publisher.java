package keepAccount.prototypeRe2;

import java.util.HashMap;
import java.util.Map;

public class Publisher {
    // 定期刊行物
    private Map<Integer, Manuscript> periodical = new HashMap<>();
    
    // 記録・保管
    public void archive(int yearMonth, Manuscript book) {
        periodical.put(yearMonth, book);
    }
    
    // 製本
    public Manuscript bookbinding(int yearMonth) {
        Manuscript ms = periodical.get(yearMonth);
        return ms.createCopy();
    }
}