package keepAccount.abstractFactory.purchaseBookFactory;

import keepAccount.abstractFactory.factory.*;

public class PurchaseBookDocument extends Document {
    
    public PurchaseBookDocument(String title) {
        super(title);
    }
    
    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"ja\">\n");
        sb.append("<head>\n");
        sb.append("<meta charset=\"UTF-8\">\n");
        sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        sb.append("<title>" + title + "</title>\n");
        sb.append("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.css\">\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("<h1>" + title + "</h1>\n");
        for (keepAccount.abstractFactory.factory.Record block : content) {
            sb.append(block.makeHTML());
        }
        sb.append("</body>\n");
        sb.append("</html>\n");
        
        return sb.toString();
    }
}
