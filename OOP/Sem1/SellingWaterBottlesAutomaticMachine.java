package OOP.Sem1;

import java.util.List;
import java.util.Optional;

public class SellingWaterBottlesAutomaticMachine implements VendingMachine {
    private List<Product> productList;

    public SellingWaterBottlesAutomaticMachine(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public List<Product> getProduct(String name) {
        return productList
                .stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .toList();
    }


    public List<Product> getListOfBottleOfWater(String name, double volume) {
        return productList
                .stream()
                .filter(product -> product instanceof BottleOfWater)
                .filter(product -> product.getName().equalsIgnoreCase(name) && ((BottleOfWater) product).getVolume() == volume)
                .toList();
    }
}
