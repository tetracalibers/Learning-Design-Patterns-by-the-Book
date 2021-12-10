import keepAccount.facade.*;

public class Main {
    public static void main(String[] args) {
        MonthlyXMLmaker.make(2021, 1, "purchasedBooksData.csv");
    }
}
