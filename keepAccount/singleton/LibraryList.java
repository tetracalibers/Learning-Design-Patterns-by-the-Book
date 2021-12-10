package keepAccount.singleton;

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
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LibraryList {
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private DOMImplementation domImpl;
    private Document document;
    // singletonパターン
    private static LibraryList singleton = new LibraryList();
    
    // コンストラクタはprivateに
    private LibraryList() {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        domImpl = builder.getDOMImplementation();
        try {
            document = domImpl.createDocument("", "library", null);
        } catch (DOMException e) {
            e.printStackTrace();
        }
    }
    
    // 唯一のインスタンスを得る
    public static LibraryList getInstance() {
        return singleton;
    }
    
    public Document getDocument() {
        return document;
    }
    
    public String dumpFile(String fileTitle) {
        String fileName = fileTitle + ".xml";
        try {
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMSource source = new DOMSource(document);
            File xmlFile = new File(fileName);
            FileOutputStream os = new FileOutputStream(xmlFile);
            StreamResult result = new StreamResult(os);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        
        String filePath = getFilePath(fileName);
        System.out.println(filePath + "としてXMLファイルを作成しました。");
        return filePath;
    }
    
    private String getFilePath(String fileName) {
        Path filePath = Paths.get(fileName);
        Path AbsPath = filePath.toAbsolutePath();
        
        return AbsPath.toString();
    }
}
