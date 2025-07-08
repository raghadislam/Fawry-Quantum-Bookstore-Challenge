package Command;

import Model.Book;
import Model.PaperBook;
import Service.PurchaseContext;

public class ReduceStockCommand implements PurchaseCommand {
    @Override
    public void execute(Book book, PurchaseContext context) {
        if (book instanceof PaperBook paperBook) {
            paperBook.reduceStock(context.quantity);
        }
    }
}
