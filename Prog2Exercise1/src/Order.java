import java.util.List;

public class Order {
    private static long counter;
    private final long orderNumber;
    private final List<Item> items;

    public Order(Item... items) {
        this.items = List.of(items);
        counter++;
        this.orderNumber = counter;
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append("Receipt for order #").append(orderNumber).append("\n-----------\n");
        for (Item item : items) {
            receipt.append(item.toString()).append("\n");
        }
        receipt.append("Total excl. VAT: ").append(getTotalValue()).append("\n");
        receipt.append("Total incl. VAT: ").append(getTotalValuePlusVAT()).append("\n");

        return receipt.toString();
    }

    public double getTotalValuePlusVAT() {
        double totalValueWithVAT = 0;
        for (Item item : items) {
            totalValueWithVAT += item.getPriceWithVAT();
        }
        return totalValueWithVAT;
    }

    public double getTotalValue() {
        double totalValue = 0;
        for (Item item : items) {
            totalValue += item.getPrice();
        }
        return totalValue;
    }
}
