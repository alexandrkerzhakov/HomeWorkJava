package GeekBrains.JDK.Seminar3;

//sum(), multiply(), divide(), subtract()
public class Calculator {
    public static <T extends Number> double sum(T t1, T t2) {
        return t1.doubleValue() + t2.doubleValue();
    }

    public static <T extends Number> double multiply(T t1, T t2) {
        return t1.doubleValue() * t2.doubleValue();
    }

    public static <T extends Number> double divide(T t1, T t2) {
        return t1.doubleValue() / t2.doubleValue();
    }

    public static <T extends Number> double subtract(T t1, T t2) {
        return t1.doubleValue() - t2.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(sum(Integer.valueOf(5), Float.valueOf(2.5f))); // 7.5
        System.out.println(multiply(Integer.valueOf(5), Float.valueOf(2.5f))); // 12.5
        System.out.println(divide(Integer.valueOf(5), Float.valueOf(2.5f))); // 2.0
        System.out.println(subtract(Integer.valueOf(5), Float.valueOf(2.5f))); // 2.5
    }

}
