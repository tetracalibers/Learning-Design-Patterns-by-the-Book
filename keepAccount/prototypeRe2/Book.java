package keepAccount.prototypeRe2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.Arrays;
import java.util.stream.Stream;

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
    public Element order(String[] datas) {
        Element book = document.createElement("book");
        String title = datas[0];
        int year = Integer.parseInt(datas[1]);
        int month = Integer.parseInt(datas[2]);
        int date = Integer.parseInt(datas[3]);
        String paymentMethod = datas[4];
        String shop = datas[5];
        int price = Integer.parseInt(datas[6]);
        String[] discountsStr = Arrays.copyOfRange(datas, 7, datas.length);
        int[] discounts = Stream.of(discountsStr).mapToInt(Integer::parseInt).toArray();
        int discountTotal = Arrays.stream(discounts).sum();
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
