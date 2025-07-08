package Validation;

import Model.Book;

public class NameValidator extends BookValidator {
    @Override
    protected void handle(Book book) {
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            throw new IllegalArgumentException("Author name cannot be empty");
        }
    }
}
