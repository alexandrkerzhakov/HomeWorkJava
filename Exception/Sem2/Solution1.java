package GeekBrains.Exception.Sem2;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Solution1 {
    public static String inputLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дробное число (тип float) -> ");
        return scanner.next();
    }

    public static Float parseFloatFromInput() {
        float number = 0;
        try {
            number = Float.parseFloat(inputLine());
        } catch (Exception e) {
            System.out.println("Введено некорректное число, повторите ввод!");
            number = Float.parseFloat(inputLine());
        }
        return number;
    }

    public static void main(String[] args) {
        float number = parseFloatFromInput();
        System.out.printf("Введенное дробное число -> " + number);
    }
}
