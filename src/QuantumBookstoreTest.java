import Factory.BookFactory;
import Model.Book;
import Service.InventoryService;

import java.util.List;

public class QuantumBookstoreTest {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();

        Book paper = BookFactory.createPaperBook("ISBN001", "The Days", "Taha Hussein", 1938, 450, 5);
        Book ebook = BookFactory.createEBook("ISBN002", "Clean Code", "Robert C. Martin", 2008, 300, "PDF");
        Book demo = BookFactory.createShowcaseBook("ISBN003", "The Future of Learning", "Raghad Islam", 2025);

        inventory.addBook(paper);
        inventory.addBook(ebook);
        inventory.addBook(demo);

        inventory.removeOutdatedBooks(88);

        try {
            inventory.buyBook("ISBN001", 2, "user@Gmail.com", "Cairo, Maady");
            inventory.buyBook("ISBN002", 1, "reader@Hotmail.com", "Mansoura, Gehan Street");
            inventory.buyBook("ISBN003", 1, "demo@Gmail.com", "Cairo, October");
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }
    }
}
