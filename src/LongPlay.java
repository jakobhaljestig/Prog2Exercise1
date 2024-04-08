import java.time.Year;

public class LongPlay extends Recording {
    private static final int PRICE_INCREASE_PER_YEAR = 5;

    public LongPlay(String name, String artist, int year, int condition, double price) {
        super(name, artist, year, condition, price);
    }

    @Override
    public String getType() {
        return "LP";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + (Year.now().getValue() - this.getYear()) * PRICE_INCREASE_PER_YEAR;
    }
}
