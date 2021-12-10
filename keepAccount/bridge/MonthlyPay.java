import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DOMException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.OutputKeys;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Identity;
import java.nio.file.Files;
import java.util.Arrays;

public class MonthlyPay extends TermPay {
    private String year;
    private String month;
    private Integer[] amountPaids;
    
    public MonthlyPay(int year, int month) {
        this.year = String.valueOf(year);
        this.month = String.valueOf(month);
    }
    
    @Override
    public Integer[] getData(String filePathStr) {
        Path filePath = Paths.get("purchasedBooks/" + filePathStr).toAbsolutePath();
        
        Documetn document = null;
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new File(filePath.toString()));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        NodeList amountPaidNodes = document.getDocumentElement().getElementsByTagName("amountPaid");
        amountPaids = Integer[amountPaidNodes.getLength()];
        for (int i = 0; i < amountPaidNodes.getLength(); i++) {
            amountPaids[i] = Integer.parseInt(amountPaidNodes.item(i).getNodeValue());
        }
        
        return amountPaids;
    }
    
    @Override
    public Integer calcTotal() {
        return Arrays.stream(amountPaids).sum();
    }
    
    @Override
    public void recordTotal() {
        Path recordFilePath = Paths.get("purchasedBooks/totalization/" + year + ".xml").toAbsolutePath();
        File recordFile = new File(recordFilePath.toString());
        
        DocumentBuilder builder = null;
        try {
            builder = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (Files.exists(recordFilePath)) {
            Document document = builder.parse(recordFile);
            Element root = document.getRootElement();
            root = addElement(root);
        } else {
            Document document = builder.newDocument();
            Element root = document.createElement("year");
            document.appendChild(root);
            root = addElement(root);
            createXMLfile(recordFile, document);
        }
    }
    
    @Override
    public void printTotal() {
        
    }
    
    private Element addElement(Element root) {
        Element monthEl = document.createElement("month");
        monthEl.setAttribute(id, month);
        monthEl.appendChild(calcTotal());
        root.appendChild(monthEl);
        
        return root;
    }
    
    private void createXMLfile(File file, Document document) {
        try {
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMSource source = new DOMSource(document);
            FileOutputStream os = new FileOutputStream(file);
            StreamResult result = new StreamResult(os);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
