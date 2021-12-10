package keepAccount.facade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CSVparser {
    File f;
    BufferedReader br;
    String header;
    
    public CSVparser(String fileName) {
        try {
            this.f = new File(fileName);
            this.br = new BufferedReader(new FileReader(f));
            this.header = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> getRows() {
        List<String> rows = new ArrayList<>();
        
        try {
            String line = br.readLine();
            while (line != null) {
                rows.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return rows;
    }
    
    public String[] rowDivideCommas(String row) {
        String[] data;
        data = row.split(",");
        
        return data;
    }
    
    public Map<String, String> rowMakeHash(String row) {
        String[] keys = rowDivideCommas(header);
        String[] values = rowDivideCommas(row);
        Map<String, String> result = new HashMap<>();
        int i = 0;
        
        for (String key : keys) {
            String value = "";
            
            try {
                value = values[i++];
            } catch (ArrayIndexOutOfBoundsException e) {
                value = "0";
            }
            result.put(key, value);
        }
        
        return result;
    }
}
