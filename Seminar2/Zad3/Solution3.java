package GeekBrains.Seminar2.Zad3;

// Реализовать простой калькулятор

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution3 {

    public static double getNumberN() {
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

    public static void doCalculator(String operation) {
        double a = getNumberN();
        double b = getNumberN();

        switch (operation) {
            case "plus":
                System.out.println("Сумма чисел " + a + " и " + b + " -> " + (a + b));
                break;
            case "minus":
                System.out.println("Разность чисел " + a + " и " + b + " -> " + (a - b));
                break;
            case "multiplication":
                System.out.println("Произведение чисел " + a + " и " + b + " -> " + (a * b));
                break;
            case "div":
                System.out.println("Частное чисел " + a + " и " + b + " -> " + (a / b));
                break;
            case "pow":
                System.out.println("Число " + a + " в степени " + b + " -> " + (Math.pow(a, b)));
                break;
        }

    }

    public static void main(String[] args) {
        doCalculator("pow");
    }
}
