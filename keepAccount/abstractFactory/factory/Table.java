package keepAccount.abstractFactory.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Table extends Record {
    protected List<Record> rows = new ArrayList<>();
    
    public void add(Record record) {
        rows.add(record);
    }
}
