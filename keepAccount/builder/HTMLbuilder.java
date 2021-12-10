package keepAccount.builder;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLbuilder extends Builder {
    private StringBuilder sb = new StringBuilder();
    
    public String setStyle(String mood) {
        StringBuilder styleTag = new StringBuilder();
        
        switch (mood) {
            case "mvp":
                styleTag.append("\t<link rel=\"stylesheet\" href=\"https://unpkg.com/mvp.css\">\n");
                break;
            case "miligram":
                styleTag.append("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.css\">\n");
                break;
            default:
                styleTag.append("");
        }
        return styleTag.toString();
    }
    
    @Override
    public void buildStart(String title, String mood) {
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"ja\">\n");
        sb.append("<head>\n");
        sb.append("\t<meta charset=\"UTF-8\">\n");
        sb.append("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
        sb.append("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        sb.append(setStyle(mood));
        sb.append("\t<title>" + title + "</title>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("\t<h1>" + title + "</h1>\n");
    }
    
    @Override
    public String makeTableRow(List<String> columns) {
        StringBuilder trTag = new StringBuilder();
        trTag.append("\t\t<tr>\n");
        for (String item : columns) {
            trTag.append("\t\t\t<th>" + item + "</th>\n");
        }
        trTag.append("\t\t</tr>\n");
        
        return trTag.toString();
    }
    
    @Override
    public void makeTable(List<String> rows) {
        sb.append("\t<table>\n");
        for (String row : rows) {
            sb.append(row);
        }
        sb.append("\t</table>\n");
    }
    
    @Override
    public String makeListItem(String item) {
        StringBuilder liTag = new StringBuilder();
        liTag.append("\t\t<li>" + item + "</li>\n");
        
        return liTag.toString();
    }
    
    @Override
    public void makeList(List<String> listItems) {
        sb.append("\t<ul>\n");
        for (String listItem : listItems) {
            sb.append(listItem);
        }
        sb.append("\t</ul>\n");
    }
    
    @Override
    public void buildEnd() {
        sb.append("</body>\n");
        sb.append("</html>\n");
    }
    
    @Override
    public void makeFile(String fileTitle) {
        String fileName = fileTitle + ".html";
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
