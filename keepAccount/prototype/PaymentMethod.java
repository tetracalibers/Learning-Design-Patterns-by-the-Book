package keepAccount.prototype;

import keepAccount.iterator.*;
import java.util.Iterator;

public class PaymentMethod implements Category {
    private String paymentMethodName;
    
    public PaymentMethod(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }
    
    @Override
    public Integer total(BookShelf bookShelf) {
        int sum = 0;
        Iterator<Book> ite = bookShelf.iterator();
        while (ite.hasNext()) {
            Book b = ite.next();
            if (b.getPaymentMethod() == paymentMethodName) {
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
