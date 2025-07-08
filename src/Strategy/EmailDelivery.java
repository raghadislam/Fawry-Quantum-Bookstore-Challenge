package Strategy;

import Model.Book;
import Model.EBook;
import Service.MailService;

public class EmailDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Book book, String email, String address) {
        if (book instanceof EBook ebook) {
            MailService.send(ebook, email);
        } else {
            throw new IllegalArgumentException("Email delivery not supported for: " + book.getTitle());
        }
    }
}