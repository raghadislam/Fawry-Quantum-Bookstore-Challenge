package Command;

import Model.Book;
import Service.PurchaseContext;

public interface PurchaseCommand {
    void execute(Book book, PurchaseContext context);
}
