package Model;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, year, 0);
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }

    @Override
    public void deliver(String email, String address) {
        throw new UnsupportedOperationException("Showcase books cannot be delivered.");
    }
}
