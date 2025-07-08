package Strategy;

import Model.Book;

public class NoDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Book book, String email, String address) {
        throw new UnsupportedOperationException("This book cannot be delivered.");
    }
}
