import keepAccount.builder.*;

public class Main {
    public static void main(String[] args) {
        HTMLbuilder HTMLbld = new HTMLbuilder();
        Director drc = new Director(HTMLbld);
        DataCarrier dtc = new DataCarrier();
        drc.construct("builderOutput", "miligram", dtc.parseXML("templateMethodOutput.xml"));
    }
}