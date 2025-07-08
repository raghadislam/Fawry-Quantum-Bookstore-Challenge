package Model;

import Service.ShippingService;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    public int getStock() { return stock; }

    public void reduceStock(int quantity) {
        if (stock < quantity) throw new RuntimeException("Not enough stock for: " + title);
        stock -= quantity;
    }

    @Override
    public boolean isPurchasable() {
        return stock > 0;
    }

    @Override
    public void deliver(String email, String address) {
        ShippingService.send(this, address);
    }
}
