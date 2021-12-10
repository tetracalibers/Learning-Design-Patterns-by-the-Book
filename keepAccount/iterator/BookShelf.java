package keepAccount.iterator;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    
    private List<Book> bookShelf;
    
    public BookShelf(int initialCount) {
        this.bookShelf = new ArrayList<>(initialCount);
    }
    
    public void addBook(Book book) {
        bookShelf.add(book);
    }
    
    public Book getBookAt(int index) {
        return bookShelf.get(index);
    }
    
    public int getCount() {
        return bookShelf.size();
    }
    
    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
