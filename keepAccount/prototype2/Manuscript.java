package keepAccount.prototype2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface Manuscript extends Cloneable {
    public abstract Manuscript createCopy();
    public abstract Element order(String title, int year, int month, int date, String paymentMethod, String shop, int price, int ... discount);
}
