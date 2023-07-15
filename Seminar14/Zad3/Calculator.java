package GeekBrains.Seminar14.Zad3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Calculator {

// В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.

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

    public static double getCalculatorResult(double a, double b) {
        double result = 0;
        String operation = "";
        int indexOperation = new Random().nextInt(4);
        switch (indexOperation) {
            case 0:
                operation = "+";
                break;
            case 1:
                operation = "-";
                break;
            case 2:
                operation = "*";
                break;
            case 3:
                operation = "/";
                break;
        }
        switch (operation) {
            case "+":
                result = a + b;
                System.out.println("Сумма чисел " + a + " и " + b + " -> " + result);
                break;
            case "-":
                result = a - b;
                System.out.println("Разность чисел " + a + " и " + b + " -> " + result);
                break;
            case "*":
                result = a * b;
                System.out.println("Произведение чисел " + a + " и " + b + " -> " + result);
                break;
            case "/":
                result = a / b;
                System.out.println("Частное чисел " + a + " и " + b + " -> " + result);
                break;
        }
        return result;
    }

    public static void getLastResult() {
        LinkedList<Double> resultList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String answer;
        double result;

        while (true) {
            double a = getNumberN();
            double b = getNumberN();
            result = getCalculatorResult(a, b);
            System.out.print("Вернуть последний результат? (yes/no) -> ");
            answer = scanner.next();
            if (answer.equals("yes")) {
                System.out.println(resultList.pollLast());
                break;
            } else if (answer.equals("no")) {
                resultList.add(result);
                continue;
            } else {
                System.out.print("Некорректный ввод, завершение программы");
                break;
            }
        }
    }

    public static void main(String[] args) {
        getLastResult();
    }
}

