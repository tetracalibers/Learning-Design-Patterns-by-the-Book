package keepAccount.abstractFactory.factory;

public abstract class Factory {
    
    public static Factory getFactory(String className) {
        Factory fc = null;
        
        try {
            fc = (Factory)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fc;
    }
    
    public abstract Receipt createReceipt(String name, String date, int price, String paymentMethod, String shop, int ... discount);
    public abstract Table createTable();
    public abstract Document createDocument(String title);
}
