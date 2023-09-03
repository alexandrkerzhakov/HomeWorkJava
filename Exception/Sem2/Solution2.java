package GeekBrains.Exception.Sem2;

public class Solution2 {
    public static void main(String[] args) {
        try {
            int d = 0;
            int[] intArray = new int[1];
            intArray[0] = 2;
            double catchedRes1 = intArray[0] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
