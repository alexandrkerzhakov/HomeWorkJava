package GeekBrains.OOP.Sem2;

public abstract class Actor implements ActorBehaviour {

    public Actor(String name) {
        this.name = name;
    }

    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;


    String getName() {
        return name;
    }

}
