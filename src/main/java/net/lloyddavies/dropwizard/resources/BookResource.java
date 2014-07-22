package net.lloyddavies.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import net.lloyddavies.dropwizard.core.Book;
import net.lloyddavies.dropwizard.services.BookService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final BookService bookService = new BookService();

    @GET
    @Timed
    public Collection<Book> getBooks() {
        return bookService.getBooks();
    }

    @GET
    @Path("/{isbn}")
    @Timed
    public Optional<Book> getBook(@PathParam("isbn") String isbn) {
        return bookService.getBook(isbn);
    }
}