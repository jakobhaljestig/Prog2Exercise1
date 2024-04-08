public abstract class Recording extends Item implements PriceableWithVAT25 {
    private final String artist;
    private final int year;
    private int condition;
    private final double price;


    protected Recording(String name, String artist, int year, int condition, double price) {
        super(name);
        this.artist = artist;
        this.year = year;
        if (condition < 0 || condition > 10) {
            throw new IllegalArgumentException("Condition must be between 0 and 10");
        }
        this.condition = condition;
        this.price = price;
    }

    public String getArtist() {
        return this.artist;
    }

    public abstract String getType();

    public int getCondition() {
        return this.condition;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public double getPrice() {
        double price = this.price * (this.condition / 10.0);
        if (price < 10) {
            price = 10;
        }
        return price;
    }

    @Override
    public String toString() {
        return getType() +
                " { name=" + getName() +
                ", artist='" + getArtist() +
                "', year=" + getYear() +
                ", condition=" + getCondition() +
                ", original price= " + getOriginalPrice() +
                ", price=" + getPrice() +
                ", price+vat=" + getPriceWithVAT() + " }";
    }

    protected double getOriginalPrice() {
        return this.price;
    }
}
