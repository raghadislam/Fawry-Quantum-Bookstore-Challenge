package Factory;

import Strategy.*;
import Model.*;
import Validation.*;

public class BookFactory {
    public static PaperBook createPaperBook(String isbn, String title, String author, int year, double price, int stock) {
        PaperBook book = new PaperBook(isbn, title, author, year, price, stock);
        book.setDeliveryStrategy(new ShippingDelivery());
        BookValidator validator = BookValidationChain.defaultChain();
        validator.validate(book);
        return book;
    }

    public static EBook createEBook(String isbn, String title, String author, int year, double price, String fileType) {
        EBook book = new EBook(isbn, title, author, year, price, fileType);
        book.setDeliveryStrategy(new EmailDelivery());
        BookValidator validator = BookValidationChain.defaultChain();
        validator.validate(book);
        return book;
    }

    public static ShowcaseBook createShowcaseBook(String isbn, String title, String author, int year) {
        ShowcaseBook book = new ShowcaseBook(isbn, title, author, year);
        book.setDeliveryStrategy(new NoDelivery());
        BookValidator validator = BookValidationChain.defaultChain();
        validator.validate(book);
        return book;
    }
}
