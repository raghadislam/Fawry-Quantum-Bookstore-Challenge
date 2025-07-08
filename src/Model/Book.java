package Model;

public abstract class Book {
    protected String ISBN;
    protected String title;
    protected String author;
    protected int yearPublished;
    protected double price;
    protected Strategy.DeliveryStrategy deliveryStrategy;

    public Book(String ISBN, String title, String author, int yearPublished, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYearPublished() { return yearPublished; }
    public double getPrice() { return price; }
    public abstract boolean isPurchasable();


    public void setDeliveryStrategy(Strategy.DeliveryStrategy strategy) {
        this.deliveryStrategy = strategy;
    }

    public void deliver(String email, String address) {
        if (deliveryStrategy == null)
            throw new IllegalStateException("No delivery strategy assigned to book: " + title);
        deliveryStrategy.deliver(this, email, address);
    }
}
