package keepAccount.abstractFactory.purchaseBookFactory;

import keepAccount.abstractFactory.factory.*;

public class PurchaseBookTable extends Table {
    
    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<table>\n");
        
        sb.append("<tr>\n");
        sb.append("<th>購入日</th>\n");
        sb.append("<th>本の題名</th>\n");
        sb.append("<th>価格</th>\n");
        sb.append("<th>総割引額</th>\n");
        sb.append("<th>支払い金額</th>\n");
        sb.append("<th>支払い方法</th>\n");
        sb.append("<th>購入店</th>\n");
        sb.append("</tr>\n");
        
        for (keepAccount.abstractFactory.factory.Record row : rows) {
            sb.append(row.makeHTML());
        }
        
        sb.append("</table>\n");
        
        return sb.toString();
    }
}
