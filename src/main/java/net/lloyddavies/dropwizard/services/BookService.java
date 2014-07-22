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
        BOOKS.put("1234567890", new Book("1234567890", "Bob Smith", "Fairy Tales"));
        BOOKS.put("1122334455", new Book("1122334455", "Sarah Jones", "Blah Blah Blah"));
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
