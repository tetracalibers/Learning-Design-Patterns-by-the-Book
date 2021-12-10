package keepAccount.prototype;

import keepAccount.iterator.*;
import java.lang.Cloneable;
import java.util.Iterator;

public interface Category extends Cloneable {
    public abstract Integer total(BookShelf bookShelf);
    public abstract Category createCopy();
}
