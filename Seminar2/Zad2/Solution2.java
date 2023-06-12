package GeekBrains.Seminar2.Zad2;

// 2) Вывести все простые числа от 1 до 1000

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution2 {
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

    public static boolean isOneDigit(int number) {
        return (number / 10 == 0);
    }

    public static boolean isHaveDivisor(int number) {
        if (isOneDigit(number)) {
            return (number % 2 == 0);
        }
        return (number % 2 == 0 || number % 3 == 0 || number % 5 == 0 || number % 7 == 0);
    }

    public static void printSimpleNumber(int n) {
        for (int i = 1; i < n; i++) {
            if (!isHaveDivisor(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        printSimpleNumber(1000);
    }
}
