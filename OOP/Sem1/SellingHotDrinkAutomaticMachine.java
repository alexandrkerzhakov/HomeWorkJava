package OOP.Sem1;

import java.util.List;

public class SellingHotDrinkAutomaticMachine implements VendingMachine{
    List<Product> productList;

    public SellingHotDrinkAutomaticMachine(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public List<Product> getProduct(String name) {
        return productList
                .stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .toList();
    }


    public List<Product> getListHotOfDrink(String name, int temperature) {
        return productList
                .stream()
                .filter(product -> product instanceof HotDrink)
                .filter(product -> product.getName().equalsIgnoreCase(name) && ((HotDrink) product).getTemperature() == temperature)
                .toList();
    }
}
