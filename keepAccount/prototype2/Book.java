package keepAccount.prototype2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.Arrays;

public class Book implements Manuscript {
    private String title;
    private int year;
    private int month;
    private int date;
    private String paymentMethod;
    private String shop;
    private int price;
    private int discountTotal;
    private Document document;
    
    public Book(Document document) {
        this.document = document;
    }
    
    // 本を注文する
    @Override
    public Element order(String title, int year, int month, int date, String paymentMethod, String shop, int price, int ... discount) {
        Element book = document.createElement("book");
        book.appendChild(printReceipt("purchasedate", year + "/" + month + "/" + date));
        book.appendChild(printReceipt("title", title)); 
        book.appendChild(printReceipt("price", String.valueOf(price)));
        book.appendChild(printReceipt("discount", String.valueOf(discountTotal)));
        book.appendChild(printReceipt("amountPaid", String.valueOf(price - discountTotal)));
        book.appendChild(printReceipt("paymentMethod", paymentMethod));
        book.appendChild(printReceipt("shop", shop));
        
        return book;
    }
    
    private Element printReceipt(String tagName, String tagInnerText) {
        Element tag = document.createElement(tagName);
        tag.appendChild(document.createTextNode(tagInnerText));
        
        return tag;
    }
    
    @Override
    public Manuscript createCopy() {
        Manuscript book = null;
        
        try {
            book = (Manuscript)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return book;
    }
}
