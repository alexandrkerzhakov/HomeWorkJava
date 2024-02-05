package GeekBrains.Core.Seminar1.src.package1;

// Реализовать простой калькулятор

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public double getNumber() throws IOException {
        double number = 0;
        System.out.print("Введите число -> ");
        try {
            number = Double.parseDouble(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("Ошибка при введении числа");
        }
        return number;
    }

    public int getNumberOfOperation() throws IOException {
        int numberOfOperation = 0;
        System.out.print("Введите порядковый номер операции над числами:\n" +
                "1 -> +\n" +
                "2 -> -\n" +
                "3 -> *\n" +
                "4 -> /\n" +
                "№ -> ");
        try {
            numberOfOperation = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("Ошибка при введении типа операции!");
        }
        return numberOfOperation;
    }

    public void doCalculator() throws Exception {
        double a = getNumber();
        double b = getNumber();
        int typeOperation = getNumberOfOperation();
        bufferedReader.close();
        switch (typeOperation) {
            case 1:
                System.out.println("Сумма чисел " + a + " и " + b + " -> " + (a + b));
                break;
            case 2:
                System.out.println("Разность чисел " + a + " и " + b + " -> " + (a - b));
                break;
            case 3:
                System.out.println("Произведение чисел " + a + " и " + b + " -> " + (a * b));
                break;
            case 4:
                if (b != 0) {
                    System.out.println("Частное чисел " + a + " и " + b + " -> " + (a / b));
                    break;
                } else throw new ArithmeticException("Обработано исключение -> деление на ноль");
            default:
                System.out.println("Такой операции нет");
        }
    }
}
