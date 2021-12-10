import keepAccount.iterator.*;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(5);
        
        Book book1 = new Book("スラスラわかるJava第2版");
        book1.setPurchaseDate("2021/11/20");
        book1.setPrice(600);
        book1.setDiscount(52);
        book1.setPaymentMethod("クレジットカード");
        book1.setShop("メルカリ");
        bookShelf.addBook(book1);
        
        Book book2 = new Book("Rubyの冒険 遊遊編");
        book2.setPurchaseDate("2021/11/20");
        book2.setPrice(400);
        book2.setPaymentMethod("メルペイ残高");
        book2.setShop("メルカリ");
        bookShelf.addBook(book2);
        
        Book book3 = new Book("Rubyの冒険 旅立ち編");
        book3.setPurchaseDate("2021/11/20");
        book3.setPrice(400);
        book3.setPaymentMethod("メルペイ残高");
        book3.setShop("メルカリ");
        bookShelf.addBook(book3);
        
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book);
        }
    }
}

// 2021/11/20にメルカリで購入「スラスラわかるJava第2版」600円から52円値引きで548円をクレジットカードで支払い
// 2021/11/20にメルカリで購入「Rubyの冒険 遊遊編」400円から0円値引きで400円をメルペイ残高で支払い
// 2021/11/20にメルカリで購入「Rubyの冒険 旅立ち編」400円から0円値引きで400円をメルペイ残高で支払い
