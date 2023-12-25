package GeekBrains.Itogovaya.OOP_8.Animals;

import java.util.Date;
import java.util.List;

public abstract class Animals {
    String name;
    Date birth;
    List<String> commands;

    public Animals(String name, Date birth, List<String> commands) {
        this.name = name;
        this.birth = birth;
        this.commands = commands;
    }
}
