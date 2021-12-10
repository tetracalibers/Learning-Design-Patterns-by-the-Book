public class Pay {
    private TermPay impl;
    
    public Pay(TermPay impl) {
        this.impl = impl;
    }
    
    public void getData() {
        impl.getData();
    }
    
    public void calcTotal() {
        impl.calcTotal();
    }
    
    public void recordTotal() {
        impl.recordTotal();
    }
    
    public void printTotal() {
        impl.printTotal();
    }
    
    public final void totalization() {
        getData();
        calcTotal();
        recordTotal();
        printTotal();
    }
}
