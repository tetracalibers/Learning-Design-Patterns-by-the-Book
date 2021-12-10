package keepAccount.iterator;

import java.lang.StringBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Book {
    private String title;
    private String purchaseDate;
    private int price;
    private int discount;
    private String paymentMethod;
    private String shop;
    
    public Book(String title) {
        this.title = title;
        this.purchaseDate = getToday();
        this.price = 0;
        this.discount = 0;
        this.paymentMethod = "未登録";
        this.shop = "未登録";
    }
    
    public String getToday() {
        SimpleDateFormat dateType = new SimpleDateFormat("yyyy/mm/dd");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        String todayStr = dateType.format(today);
        
        return todayStr;
    }
    
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void setShop(String shop) {
        this.shop = shop;
    }
    
    public String getShop() {
        return this.shop;
    }
    
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public int getAmountPaid() {
        return this.price - this.discount;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(purchaseDate).append("に");
        sb.append(shop).append("で購入");
        sb.append("「").append(title).append("」");
        sb.append(price).append("円から").append(discount).append("円値引きで");
        sb.append(price - discount).append("円を");
        sb.append(paymentMethod).append("で支払い");
        
        return sb.toString();
    }
}
