package GeekBrains.Itogovaya.OOP_8.Animals.Pets;

import GeekBrains.Itogovaya.OOP_8.Animals.Pets.Pets;

import java.util.Date;
import java.util.List;

public class Cat extends Pets {
    public Cat(String name, Date birth, List<String> commands) {
        super(name, birth, commands);
    }
}
