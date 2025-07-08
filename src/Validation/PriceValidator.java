package Validation;

import Model.Book;

public class PriceValidator extends BookValidator{
    @Override
    protected void handle(Book book) {
        if(book.getPrice() < 0) {
            throw new IllegalArgumentException("Book price must be non-negative");
        }
    }
}
