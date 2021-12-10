public class Main {
    public static void main(String[] args) {
        Grouping file = new MonthlyGrouping(2020, 12, "purchasedBooksData.csv");
        Grouping dir1 = new YearlyDirectory(file);
        Grouping dir2 = new OutmostDirectory(dir1);
        
        dir2.dumpResult();
    }
}
