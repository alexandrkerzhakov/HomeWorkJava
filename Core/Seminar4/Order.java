package GeekBrains.Core.Seminar4;

public class Order {
    private int id;
    private final Customer customer;

    private final Product product;

    public Order(int id, Customer customer, Product product) {
        this.id = id;
        this.customer = customer;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }
}
