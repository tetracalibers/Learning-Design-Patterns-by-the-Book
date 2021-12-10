package keepAccount.adapter;

import keepAccount.iterator.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class MakeFileBook extends MakeFile {
    private BookShelf books;
    
    public MakeFileBook(BookShelf books) {
        this.books = books;
    }
    
    @Override
    public void makeText() {
        Iterator<Book> it = books.iterator();
        try {
            FileWriter fw = new FileWriter("adapterOutput.txt");
            while (it.hasNext()) {
                Book book = it.next();
                fw.append(book.toString());
                fw.append("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
