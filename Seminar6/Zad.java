package GeekBrains.Seminar6;
/*
Пусть дан произвольный список целых чисел
1) Нужно удалить из него четные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение
 */

import java.util.*;
import java.util.stream.Collectors;

public class Zad {


    public static int getSize() {
        return new Random().nextInt(51);
    }

    public static int getNumber() {
        return new Random().nextInt(101);
    }

    public static List<Integer> getList() {
        List<Integer> integerList = new ArrayList<>();
        int size = getSize();
        for (int i = 0; i < size; i++) {
            integerList.add(getNumber());
        }
        return integerList;
    }

    public static void printList(List<Integer> list) {
        System.out.print("Выводим элементы списка в консоль -> ");
        for (Integer value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static List<Integer> delEven(List<Integer> list) {
        return list
                .stream()
                .filter(element -> element % 2 == 1)
                .collect(Collectors.toList());
    }

    public static int getMin(List<Integer> list) {
        return Collections.min(list);
    }

    public static int getMax(List<Integer> list) {
        return Collections.max(list);
    }

    public static double getArithmeticMean(List<Integer> list) {
        int result = list
                .stream()
                .reduce(0, (sub, element) -> sub + element);
        return (double) result/list.size();
    }

    public static void main(String[] args) {
        List<Integer> randomlist = getList();
        printList(randomlist);
        List<Integer> listWithEven = delEven(randomlist);
        printList(listWithEven);
        System.out.println("Минимальный элемент из списка -> " + getMin(randomlist));
        System.out.println("Максимальный элемент из списка -> " + getMax(randomlist));
        System.out.println("Среднее арифметическое элементов из списка -> " + getArithmeticMean(randomlist));

    }
}
