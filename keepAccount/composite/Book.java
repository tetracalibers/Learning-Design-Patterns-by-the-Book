package keepAccount.composite;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.Arrays;

public class Book extends Volume {
    private String title;
    private int year;
    private int month;
    private int date;
    private String purchaseFullDate;
    private String paymentMethod;
    private String shop;
    private int price;
    private int discountTotal;
    
    public Book(String title, int year, int month, int date, String paymentMethod, String shop, int price, int ... discount) {
        this.title = title;
        this.year = year;
        this.month = month;
        this.date = date;
        this.purchaseFullDate = year + "/" + month + "/" + date;
        this.paymentMethod = paymentMethod;
        this.shop = shop;
        this.price = price;
        this.discountTotal = Arrays.stream(discount).sum();
        this.self = arrange();
    }
    
    // 本を手配（購入）する
    @Override
    protected Element arrange() {
        Element book = document.createElement("book");
        book.appendChild(createLabel("purchasedate", purchaseFullDate));
        book.appendChild(createLabel("title", title)); 
        book.appendChild(createLabel("price", String.valueOf(price)));
        book.appendChild(createLabel("discount", String.valueOf(discountTotal)));
        book.appendChild(createLabel("amountPaid", String.valueOf(price - discountTotal)));
        book.appendChild(createLabel("paymentMethod", paymentMethod));
        book.appendChild(createLabel("shop", shop));
        
        return book;
    }
    
    private Element createLabel(String tagName, String tagInnerText) {
        Element tag = document.createElement(tagName);
        tag.appendChild(document.createTextNode(tagInnerText));
        
        return tag;
    }
}
