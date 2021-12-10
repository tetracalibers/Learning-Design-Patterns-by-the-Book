package keepAccount.abstractFactory.purchaseBookFactory;

import keepAccount.abstractFactory.factory.*;

public class PurchaseBookFactory extends Factory {
    
    @Override
    public Receipt createReceipt(String name, String date, int price, String paymentMethod, String shop, int ... discount) {
        return new PurchaseBookReceipt(name, date, price, paymentMethod, shop, discount);
    }
    
    @Override 
    public Table createTable() {
        return new PurchaseBookTable();
    }
    
    @Override 
    public Document createDocument(String title) {
        return new PurchaseBookDocument(title);
    }
}
