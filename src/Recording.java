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
        return artist;
    }

    public int getYear() {
        return year;
    }

    public int getCondition() {
        return condition;
    }

    protected double getOriginalPrice() {
        return price;
    }

    @Override
    public double getPrice() {
        double adjustedPrice = price * (condition / 10.0);
        if (adjustedPrice < 10) {
            adjustedPrice = 10;
        }
        return adjustedPrice;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() +
                " { name=" + getName() +
                ", artist='" + artist +
                "', year=" + year +
                ", condition=" + condition +
                ", original price= " + price +
                ", price=" + getPrice() +
                ", price+vat=" + getPriceWithVAT() + " }";
    }
}
