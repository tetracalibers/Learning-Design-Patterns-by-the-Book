import keepAccount.iterator.*;
import keepAccount.factoryMethod.*;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("スラスラわかるJava第2版");
        book1.setPurchaseDate("2021/11/20");
        book1.setPrice(600);
        book1.setDiscount(52);
        book1.setPaymentMethod("クレジットカード");
        book1.setShop("メルカリ");
        
        Book book2 = new Book("Rubyの冒険 遊遊編");
        book2.setPurchaseDate("2021/11/20");
        book2.setPrice(400);
        book2.setPaymentMethod("メルペイ残高");
        book2.setShop("メルカリ");
        
        Book book3 = new Book("Rubyの冒険 旅立ち編");
        book3.setPurchaseDate("2021/11/20");
        book3.setPrice(400);
        book3.setPaymentMethod("メルペイ残高");
        book3.setShop("メルカリ");
        
        TabularFormatter tbFactory = new TabularFormatter(book1, book2, book3);
        
        Table LaTeXtable = tbFactory.create("LaTeX");
        LaTeXtable.dumpFile("factoryMethodOutput");
        
        Table HTMLtable = tbFactory.create("HTML");
        HTMLtable.dumpFile("factoryMethodOutput");
    }
}
