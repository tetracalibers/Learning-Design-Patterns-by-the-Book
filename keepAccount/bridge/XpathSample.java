import keepAccount.singleton.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.DOMException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    
    public static void main(String[] args) {
        Document document = null;
        
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new File(Paths.get("library.xml").toAbsolutePath().toString()));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        
        XPathExpression expression = null;
        NodeList nodes = null;
        try {
            expression = path.compile("//book[paymentMethod/text()='クレジットカード']");
            nodes = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        LibraryList lib = LibraryList.getInstance();
        Document result = lib.getDocument();
        int i = 0;
        
        while (i < nodes.getLength()) {
            Node importedNode = result.importNode(nodes.item(i++), true);
            result.getDocumentElement().appendChild(importedNode);
        }
        
        lib.dumpFile("xpathTest");
    }
}
