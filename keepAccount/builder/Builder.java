package keepAccount.builder;

import java.util.ArrayList;
import java.util.List;

public abstract class Builder {
    public abstract void buildStart(String title, String mood);
    public abstract String makeTableRow(List<String> columns);
    public abstract void makeTable(List<String> rows);
    public abstract String makeListItem(String item);
    public abstract void makeList(List<String> listItems);
    public abstract void buildEnd();
    public abstract void makeFile(String fileTitle);
}
