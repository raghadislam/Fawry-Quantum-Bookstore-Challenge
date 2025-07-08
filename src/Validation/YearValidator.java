package Validation;

import Model.Book;

import java.time.Year;

public class YearValidator extends BookValidator {
    @Override
    protected void handle(Book book) {
        int currentYear = Year.now().getValue();
        if (book.getYearPublished() > currentYear) {
            throw new IllegalArgumentException("Year published cannot be in the future");
        }
    }
}
