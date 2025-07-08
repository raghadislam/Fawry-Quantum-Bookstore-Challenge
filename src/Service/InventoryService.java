package Service;

import Model.Book;
import Command.*;
import java.time.Year;
import java.util.*;

public class InventoryService {
    private final Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
        System.out.println("Added " + book.getTitle());
    }

    public List<Book> removeOutdatedBooks(int maxAge) {
        List<Book> removed = new ArrayList<>();
        int currentYear = Year.now().getValue();

        for (Iterator<Book> it = inventory.values().iterator(); it.hasNext(); ) {
            Book book = it.next();
            if (currentYear - book.getYearPublished() > maxAge) {
                removed.add(book);
                it.remove();
                System.out.println("Removed outdated book " + book.getTitle());
            }
        }
        return removed;
    }

    public double buyBook(String ISBN, int quantity, String email, String address) {
        if (!inventory.containsKey(ISBN)) throw new RuntimeException("Book not found: " + ISBN);
        Book book = inventory.get(ISBN);


        PurchaseContext context = new PurchaseContext(email, address, quantity);

        List<PurchaseCommand> commands = List.of(
                new ValidateAvailabilityCommand(),
                new ReduceStockCommand(),
                new DeliverCommand(),
                new PrintReceiptCommand()
        );

        for (PurchaseCommand command : commands) {
            command.execute(book, context);
        }

        return book.getPrice() * quantity;
    }
}
