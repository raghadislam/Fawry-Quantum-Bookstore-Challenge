package Validation;

import Model.Book;

public abstract class BookValidator {
    protected BookValidator next;
    public BookValidator linkWith(BookValidator next) {
        this.next = next;
        return next;
    }
    public void validate(Book book) {
        handle(book);
        if (next != null) next.validate(book);
    }

    protected abstract void handle(Book book);

}
