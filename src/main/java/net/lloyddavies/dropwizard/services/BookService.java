package net.lloyddavies.dropwizard.services;

import com.google.common.base.Optional;
import net.lloyddavies.dropwizard.core.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Optional.fromNullable;

public class BookService {
    private static final Map<String, Book> BOOKS = new HashMap<String, Book>();

    static {
        BOOKS.put("123456789", new Book("123456789", "Bob Smith", "Fairy Tales"));
        BOOKS.put("222333444", new Book("222333444", "Sarah Jones", "Blah Blah Blah"));
    }

    public Collection<Book> getBooks() {
        return BOOKS.values();
    }

    public Optional<Book> getBook(String isbn) {
        return fromNullable(BOOKS.get(isbn));
    }

    public void store(Book book) {
        BOOKS.put(book.getIsbn(), book);
    }
}
