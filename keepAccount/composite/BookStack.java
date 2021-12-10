package keepAccount.composite;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

// 本の集合体は本の山
// 本の山の集合体も重ねれば本の山
public class BookStack extends Volume {
    private int year;
    private int month;
    
    public BookStack() {
        Element root = document.getDocumentElement();
        this.self = root;
    }
    
    public BookStack(int year, int month) {
        this.year = year;
        this.month = month;
        this.self = arrange();
    }
    
    // 本の山を置く場所を準備しておく
    @Override 
    protected Element arrange() {
        Element bookshelf = document.createElement("bookshelf");
        bookshelf.setAttribute("year", String.valueOf(year));
        bookshelf.setAttribute("month", String.valueOf(month));
        
        return bookshelf;
    }
    
    // 本の山の上に、本もしくは本の山を積む
    public void add(Volume volume) {
        self.appendChild(volume.getSelf());
    }
}
