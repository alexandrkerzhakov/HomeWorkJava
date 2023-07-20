package GeekBrains.OOP.Sem2;

public class Human extends Actor {

    public Human(String name) {
        super(name);
    }

    @Override
    String getName() {
        return super.getName();
    }

    @Override
    public void setMakeOrder() {
        System.out.println(this.getName() + " готов делать заказ.");
        this.isMakeOrder = true;
        this.isTakeOrder = false;

    }

    @Override
    public boolean isMakeOrder() {
        if (!this.isMakeOrder) {
            return false;
        }
        return true;
    }

    @Override
    public void setTakeOrder() {
        System.out.println(this.getName() + " готов забирать заказ.");
        this.isTakeOrder = true;
        this.isMakeOrder = false;
    }

    @Override
    public boolean isTakeOrder() {
        if (!this.isTakeOrder) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", isMakeOrder=" + isMakeOrder +
                ", isTakeOrder=" + isTakeOrder +
                '}';
    }
}
