package keepAccount.abstractFactory.purchaseBookFactory;

import keepAccount.abstractFactory.factory.*;

public class PurchaseBookReceipt extends Receipt {
    
    public PurchaseBookReceipt(String name, String date, int price, String paymentMethod, String shop, int ... discount) {
        super(name, date, price, paymentMethod, shop, discount);
    }
    
    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<tr>\n");
        sb.append("<td>" + date + "</td>\n");
        sb.append("<td>" + name + "</td>\n");
        sb.append("<td>" + price + "</td>\n");
        sb.append("<td>" + allDiscount + "</td>\n");
        sb.append("<td>" + amountPaid + "</td>\n");
        sb.append("<td>" + paymentMethod + "</td>\n");
        sb.append("<td>" + shop + "</td>\n");
        sb.append("</tr>\n");
        
        return sb.toString();
    }
}
