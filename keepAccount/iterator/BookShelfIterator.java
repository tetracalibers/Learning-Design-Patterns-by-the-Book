package keepAccount.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {
    
    private BookShelf books;
    private int index;
    
    public BookShelfIterator(BookShelf books) {
        this.books = books;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        if (index < books.getCount()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = books.getBookAt(index++);
        return book;
    }
}
