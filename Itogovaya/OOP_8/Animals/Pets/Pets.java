package GeekBrains.Itogovaya.OOP_8.Animals.Pets;

import GeekBrains.Itogovaya.OOP_8.Animals.Animals;

import java.util.Date;
import java.util.List;

public abstract class Pets extends Animals {

    public Pets(String name, Date birth, List<String> commands) {
        super(name, birth, commands);
    }
}
