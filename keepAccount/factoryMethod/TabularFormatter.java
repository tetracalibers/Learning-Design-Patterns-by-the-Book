package keepAccount.factoryMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.ReflectiveOperationException;

public class TabularFormatter extends Formatter {
    private Object[] objs;
    
    public TabularFormatter(Object ... objs) {
        this.objs = objs;
    }
    
    @Override
    protected Table createTable(String typeId) {
        Table table = null;
        switch (typeId) {
            case "latex":
                table = new LaTeXtable(objs);
                break;
            case "html":
                table = new HTMLtable(objs);
                break;
        }
        return table;
    }
}
