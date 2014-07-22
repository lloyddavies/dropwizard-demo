package net.lloyddavies.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import net.lloyddavies.dropwizard.core.Book;
import net.lloyddavies.dropwizard.services.BookService;

import javax.validation.Valid;
import javax.ws.rs.*;
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

    @POST
    @Timed
    public void getBook(@Valid Book book) {
        bookService.store(book);
    }
}