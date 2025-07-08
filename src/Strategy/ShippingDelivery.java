package Strategy;


import Model.Book;
import Model.PaperBook;
import Service.ShippingService;

public class ShippingDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Book book, String email, String address) {
        if (book instanceof PaperBook paperBook) {
            ShippingService.send(paperBook, address);
        } else {
            throw new IllegalArgumentException("Shipping not supported for: " + book.getTitle());
        }
    }
}

