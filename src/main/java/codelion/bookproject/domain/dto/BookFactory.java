package codelion.bookproject.domain.dto;

import codelion.bookproject.domain.entity.Books;

public class BookFactory {

    public static BookResponse toBookResponse(Books books) {
        return new BookResponse(
                  books.getId()
                , books.getName()
                , books.getAuthor().getAuthorName());
    }

    public static BookResponse toAllBookResponse(Books books) {
        return new BookResponse(
                books.getId()
                , books.getName()
                , books.getAuthor().getAuthorName()
                , books.getPublisher().getPublisherName()
        );
    }
}
