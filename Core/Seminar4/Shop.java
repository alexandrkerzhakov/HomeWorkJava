package GeekBrains.Core.Seminar4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static int ordersCount;

    protected static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer("John", "Wick", Gender.Male));
        customers.add(new Customer("Tom", "Wick", Gender.Male));
        customers.add(new Customer("Jack", "Wick", Gender.Male));
        customers.add(new Customer("Sam", "Wick", Gender.Male));
        customers.add(new Customer("Brus", "Wick", Gender.Male));
    }

    protected static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("mug", 5));
        products.add(new Product("fork", -2));
        products.add(new Product("plate", 0));
        products.add(new Product("tablecloth", 2));
        products.add(new Product("knife", 3));
    }

    protected static final List<Order> orders = new ArrayList<>();

    public static void writeToFile(String line) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("orders", true))) {
            bufferedWriter.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buy(String productName, String customerName) {
        Product product = findProductByName(productName);
        try {
            if (product == null) {
                throw new ProductException("This product " + productName + " not found!");
            }
        } catch (ProductException e) {
            e.printStackTrace();
            return;
        }

        try {
            if (product.getCount() <= 0) {
                throw new CountProductException("Count this product " + productName + " is not valid!");
            }
        } catch (CountProductException e) {
            e.printStackTrace();
            return;
        }

        Customer customer = findCustomerByName(customerName);
        try {
            if (customer == null) {
                throw new CustomerException("This customer " + customerName + " not found!");
            }
        } catch (CustomerException e) {
            e.printStackTrace();
            return;
        }

        Order order = new Order(++ordersCount, customer, product);
        orders.add(order);
        writeToFile(order + "\n");
        product.setCount(product.getCount() - 1);
    }

    private static Product findProductByName(String productName) {
        return products
                .stream()
                .filter(p -> p.getProductName().equals(productName))
                .findFirst()
                .orElse(null);
    }

    private static Customer findCustomerByName(String customerName) {
        return customers
                .stream()
                .filter(c -> c.getFirstName().equals(customerName))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        System.out.println(customers);
        System.out.println(products);
        System.out.println(orders);

        buy("mug", "John"); // valid
        buy("mug", "Kristina"); // This customer Kristina not found!
        buy("mug", "Tom"); // valid
        buy("pen", "Tom"); // This product pen not found!
        buy("pencil", "Vika"); // This product pencil not found!
        buy("fork", "Brus"); // Count this product fork is not valid!

        System.out.println(orders);
        System.out.println("Всего заказов -> " + ordersCount);


    }
}
