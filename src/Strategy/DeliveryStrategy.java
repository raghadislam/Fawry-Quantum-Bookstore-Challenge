package Strategy;

import Model.Book;

public interface DeliveryStrategy {
    void deliver(Book book, String email, String address);
}