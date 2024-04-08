public class Book extends Item implements PriceableWithVAT6 {
    private static final double PRICE_INCREASE_BOUND = 1.3;

    private final double price;
    private final boolean bound;
    private final String author;

    public Book(String name, String author, double price, boolean bound) {
        super(name);
        this.price = price;
        this.bound = bound;
        this.author = author;
    }

    @Override
    public double getPrice() {
        return bound ? price * PRICE_INCREASE_BOUND : price;
    }

    @Override
    public String toString() {
        return "Book { name='" + getName() + "', author='" + author + "', bound=" + bound + ", price=" + getPrice() + ", price+vat=" + getPriceWithVAT() + " }";
    }
}
