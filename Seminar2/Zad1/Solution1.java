package GeekBrains.Seminar2.Zad1;

// 1) Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {

    public static int getNumberN() {
        int n = 0;
        System.out.print("Введите число -> ");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String lineN = bufferedReader.readLine();
            n = Integer.parseInt(lineN);
        } catch (Exception e) {
            System.out.println("Error");
        }
        return n;
    }

    public static long sumOfNumber(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int n = getNumberN();
        long sum = sumOfNumber(n);
        System.out.println("Сумма чисел от 1 до " + n + " = " + sum);
        long fact = factorial(n);
        System.out.printf("Факториал чисел от 1 до " + n + " = " + fact);

    }
}
