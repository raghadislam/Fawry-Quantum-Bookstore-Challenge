#  📘 Quantum Bookstore – Java OOP Design

Quantum Bookstore is a modular, extensible console-based book inventory and sales system. It supports different book types with specific behaviors like shipping, email delivery, and non-purchasable showcases. The system is built with clean architecture and uses several design patterns to ensure flexibility, maintainability, and scalability.


---

## 📦 Features

- Add books to the inventory with metadata:
  - ISBN, title, author, year published, price
- Supported book types:
  - 📦 **PaperBook** – has stock and ships to an address
  - 📩 **EBook** – has a file type and sends via email
  - 🖼 **ShowcaseBook** – not purchasable
- Remove outdated books older than N years
- Buy a book by ISBN:
  - Validates availability and quantity
  - Delivers via shipping or email
  - Returns total paid
  - Throws appropriate errors if invalid
- Designed to support new book types with minimal changes


---

## 🎨 Design Patterns Used

| Pattern              | Purpose                                  |
|----------------------|------------------------------------------|
| **Factory**          | Centralized book creation logic          |
| **Strategy**         | Dynamic delivery behavior (ship/email)   |
| **Command**          | Encapsulated purchase steps              |
| **Chain of Responsibility** | Flexible book validation sequence     |


---

## 🧱 Project Structure

```
src/
├── command/
│ ├── PurchaseCommand.java
│ ├── ValidateAvailabilityCommand.java
│ ├── ReduceStockCommand.java
│ ├── DeliveryCommand.java
│ └── PrintReceiptCommand.java
├── factory/
│ └── BookFactory.java
├── model/
│ ├── Book.java
│ ├── PaperBook.java
│ ├── EBook.java
│ └── ShowcaseBook.java
├── service/
│ ├── InventoryService.java
│ ├── ShippingService.java
│ ├── MailService.java
│ └── PurchaseContext.java
├── strategy/
│ ├── DeliveryStrategy.java
│ ├── ShippingDelivery.java
│ ├── EmailDelivery.java
│ └── NoDelivery.java
├── validation/ 
│ ├── BookValidator.java
│ ├── NameValidator.java
│ ├── PriceValidator.java
│ ├── YearValidator.java
│ └── BookValidationChain.java
└── QuantumBookstoreTest.java
```


---

## Example Input

In `QuantumBookstoreTest.java`:

```java

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

```
## Output

```
Added The Days
Added Clean Code
Added The Future of Learning
Shipping 'The Days' to Cairo, Maady
****************************
Quantum book store: Receipt
 - Book: The Days
 - Quantity: 2
 - Total: 900 EGP
****************************
Sending 'Clean Code' to reader@Hotmail.com (PDF)
****************************
Quantum book store: Receipt
 - Book: Clean Code
 - Quantity: 1
 - Total: 300 EGP
****************************
Quantum book store: Book is not for sale: The Future of Learning
```

---

## How to Use

1. **Clone the project**
   ```bash
   git clone https://github.com/raghadislam/Fawry-Quantum-Bookstore-Challenge.git
   cd Fawry-Quantum-Bookstore-Challenge-oop
   ```
2. **Compile**
```bash
javac -d bin src/**/*.java
```

3. **Run**
```bash
java -cp bin Main
```
Or run via your IDE (IntelliJ, Eclipse).



