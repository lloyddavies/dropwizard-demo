package net.lloyddavies.dropwizard.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private String isbn;
    private String author;
    private String title;

    public Book(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    @JsonProperty
    public String getIsbn() {
        return isbn;
    }

    @JsonProperty
    public String getAuthor() {
        return author;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }
}
