package OOP.Sem1;

public class BottleOfWater extends Product {
    private double volume;

    public BottleOfWater(String name, double cost, double volume) {
        super(name, cost);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "WaterOfBottle{" +
                "volume=" + this.volume +
                ", name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                '}';
    }
}
