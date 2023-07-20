package OOP.Sem1;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        BottleOfWater chernogolovka = new BottleOfWater("Chernogolovka", 30, 0.5);
        BottleOfWater cola = new BottleOfWater("Cola", 35, 0.3);
        BottleOfWater pepsi = new BottleOfWater("Pepsi", 40, 0.2);

        HotDrink cofe = new HotDrink("Espresso", 50, 90);
        HotDrink choco = new HotDrink("Choco", 70, 70);
        HotDrink tea = new HotDrink("Tea", 50, 90);

        SellingWaterBottlesAutomaticMachine sellingWaterBottlesAutomaticMachine = new SellingWaterBottlesAutomaticMachine(List.of(chernogolovka, cola, pepsi));
        System.out.println(chernogolovka); // WaterOfBottle{volume=0.5, name='Chernogolovka', cost=30.0}
        System.out.println(sellingWaterBottlesAutomaticMachine.getProduct("Chernogolovka")); // [WaterOfBottle{volume=0.5, name='Chernogolovka', cost=30.0}]
        System.out.println(sellingWaterBottlesAutomaticMachine.getListOfBottleOfWater("Chernogolovka", 0.5)); // [WaterOfBottle{volume=0.5, name='Chernogolovka', cost=30.0}]


        SellingHotDrinkAutomaticMachine sellingHotDrinkAutomaticMachine = new SellingHotDrinkAutomaticMachine(List.of(cofe, choco, tea));
        System.out.println(tea); // HotDrink{temperature=90, name='Tea', cost=50.0}
        System.out.println(sellingHotDrinkAutomaticMachine.getProduct("Tea")); // [HotDrink{temperature=90, name='Tea', cost=50.0}]
        System.out.println(sellingHotDrinkAutomaticMachine.getListHotOfDrink("Tea", 90)); // [HotDrink{temperature=90, name='Tea', cost=50.0}]

    }
}
