package GeekBrains.Itogovaya.OOP_8.Animals.Pets;

import GeekBrains.Itogovaya.OOP_8.Animals.Pets.Pets;

import java.util.Date;
import java.util.List;

public class Dog extends Pets {
    public Dog(String name, Date birth, List<String> commands) {
        super(name, birth, commands);
    }
}
