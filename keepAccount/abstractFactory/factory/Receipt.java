package keepAccount.abstractFactory.factory;

public abstract class Receipt extends Record {
    protected String name;
    protected String date;
    protected int price;
    protected int allDiscount;
    protected int amountPaid;
    protected String paymentMethod;
    protected String shop;
    
    public Receipt(String name, String date, int price, String paymentMethod, String shop, int ... discount) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.allDiscount = 0;
        for (int d : discount) {
            allDiscount += d;
        }
        this.amountPaid = price - allDiscount;
        this.paymentMethod = paymentMethod;
        this.shop = shop;
    }
}
