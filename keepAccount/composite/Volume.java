package keepAccount.composite;

import keepAccount.singleton.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// 積み上げられた本を一冊の分厚い本とみなす
public abstract class Volume {
    private LibraryList lib = LibraryList.getInstance();
    protected Document document = lib.getDocument();
    protected Element self;
    
    public Node getSelf() {
        return self;
    }
    
    public String dumpFile(String fileTitle) {
        return lib.dumpFile(fileTitle);
    }
    
    // 準備する、手配する
    protected abstract Element arrange();
}
