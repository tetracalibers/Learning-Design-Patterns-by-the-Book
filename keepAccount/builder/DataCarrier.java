package keepAccount.builder;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class DataCarrier {
    
    public Map[] parseXML(String fileName) {
        Map[] result = null;
        try {
            File file = new File("templateMethodOutput.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbl = dbf.newDocumentBuilder();
            Document dc = dbl.parse(file);
            NodeList books = dc.getElementsByTagName("book");
            
            Map[] booksData = new Map[books.getLength()];
            result = new Map[books.getLength()];
            for (Integer i = 0; i < books.getLength(); i++) {
                Map bookinfo = new HashMap();
                Node book = books.item(i);
                for (Integer j = 1; j < book.getChildNodes().getLength(); j += 2) {
                    Node bookAttr = book.getChildNodes().item(j);
                    bookinfo.put(bookAttr.getNodeName(), bookAttr.getTextContent());
                }
                booksData[i] = bookinfo;
                System.arraycopy(booksData, 0, result, 0, booksData.length);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        return result;
    }
}
