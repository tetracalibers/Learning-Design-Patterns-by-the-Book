package keepAccount.builder;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Director {
    private Builder builder;
    
    public Director(Builder builder) {
        this.builder = builder;
    }
    
    protected List injectIntoRow(Map[] data) {
        Integer count = data.length;
        List<String> rows = new ArrayList<String>();
        List<String> columnNames = new ArrayList<String>();
        Map first = data[0];
        for (Object key : first.keySet()) {
            columnNames.add(key.toString());
        }
        rows.add(builder.makeTableRow(columnNames));
        List<String> rowData = new ArrayList<String>();
        for (Integer i = 0; i < count; i++) {
            Map item = data[i];
            rowData.clear();
            for (Object key : item.keySet()) {
                rowData.add(item.get(key).toString());
            }
            rows.add(builder.makeTableRow(rowData));
        }
        
        return rows;
    }
    
    public void construct(String title, String mood, Map[] data) {
        List rows = injectIntoRow(data);
        builder.buildStart(title, mood);
        builder.makeTable(rows);
        builder.buildEnd();
        builder.makeFile(title);
    }
}
