package keepAccount.prototype;

import keepAccount.iterator.*;
import java.util.Iterator;

public class PaymentShop implements Category {
    private String paymentShopName;
    
    public PaymentShop(String paymentShopName) {
        this.paymentShopName = paymentShopName;
    }
    
    @Override
    public Integer total(BookShelf bookShelf) {
        int sum = 0;
        Iterator<Book> ite = bookShelf.iterator();
        while (ite.hasNext()) {
            Book b = ite.next();
            if (b.getShop() == this.paymentShopName) {
                sum += b.getAmountPaid();
            }
        }
        
        return sum;
    }
    
    @Override
    public Category createCopy() {
        Category c = null;
        
        try {
            c = (Category) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return c;
    }
}
