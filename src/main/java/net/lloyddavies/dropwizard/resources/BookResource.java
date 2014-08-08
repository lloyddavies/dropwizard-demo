package net.lloyddavies.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.wordnik.swagger.annotations.*;
import net.lloyddavies.dropwizard.core.Book;
import net.lloyddavies.dropwizard.services.BookService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/books")
@Api(value = "/books", description = "the books API")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @ApiOperation(value = "All books in the store", notes = "Returns a list of all the books", response = Book.class, responseContainer = "List")
    @Timed
    public Collection<Book> getBooks() {
        return bookService.getBooks();
    }

    @GET
    @Path("/{isbn}")
    @ApiOperation(value = "Find book by ISBN", notes = "Returns a book based on ISBN", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ISBN supplied"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    @Timed
    public Optional<Book> getBook(
            @ApiParam(value = "ISBN of the book that needs to be fetched",required=true)
            @PathParam("isbn") String isbn) {
        return bookService.getBook(isbn);
    }

    @POST
    @ApiOperation(value = "Add a new book to the store", notes = "", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 422, message = "Invalid ISBN supplied")
    })
    @Timed
    public void getBook(
            @ApiParam(value = "Book object that needs to be inserted in the store", required = true)
            @Valid Book book) {
        bookService.store(book);
    }
}