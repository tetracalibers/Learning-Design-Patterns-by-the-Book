import keepAccount.templateMethod.*;
import keepAccount.iterator.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        
        AbstractMakeFile csv = new MakeCSVFile(book1, book2, book3);
        csv.makeFile("templateMethodOutput.csv");
        
        AbstractMakeFile yaml = new MakeYAMLFile(book1, book2, book3);
        yaml.makeFile("templateMethodOutput.yaml");
        
        AbstractMakeFile json = new MakeJSONFile(book1, book2, book3);
        json.makeFile("templateMethodOutput.json");
        
        AbstractMakeFile xml = new MakeXMLFile(book1, book2, book3);
        xml.makeFile("templateMethodOutput.xml");
    }
}
