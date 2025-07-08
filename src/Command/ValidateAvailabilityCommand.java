package Command;

import Model.Book;
import Model.PaperBook;
import Service.PurchaseContext;

public class ValidateAvailabilityCommand implements PurchaseCommand {
    @Override
    public void execute(Book book, PurchaseContext context) {
        if (!book.isPurchasable()) {
            throw new RuntimeException("Book is not for sale: " + book.getTitle());
        }
        if ((book instanceof PaperBook paperBook) && (paperBook.getStock() < context.quantity)) {
            throw new RuntimeException("Not enough stock for: " + book.getTitle());
        }
    }
}