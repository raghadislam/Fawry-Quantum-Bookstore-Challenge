package Command;

import Model.Book;
import Service.PurchaseContext;

public class DeliverCommand implements PurchaseCommand {
    @Override
    public void execute(Book book, PurchaseContext context) {
        book.deliver(context.email, context.address);
    }
}
