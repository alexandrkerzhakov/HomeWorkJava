package GeekBrains.Itogovaya.OOP_8.Animals.PackAnimals;

import GeekBrains.Itogovaya.OOP_8.Animals.Animals;

import java.util.Date;
import java.util.List;

public abstract class PackAnimals extends Animals {
    public PackAnimals(String name, Date birth, List<String> commands) {
        super(name, birth, commands);
    }
}
