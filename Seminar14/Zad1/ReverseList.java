package GeekBrains.Seminar14.Zad1;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;
import java.util.List;

public class ReverseList {
    public static List<String> stringLinkedList = new LinkedList<>();

    static {
        stringLinkedList.add("String1");
        stringLinkedList.add("String2");
        stringLinkedList.add("String3");
        stringLinkedList.add("String4");
        stringLinkedList.add("String5");
    }

    public static List getReverseList(List currentList) {
        System.out.print("Реверс списка -> ");
        LinkedList reverseList = new LinkedList<>();
        currentList.stream().forEach(value -> reverseList.addFirst(value));
        return reverseList;
    }

    public static void printList(List list) {
        list
                .stream()
                .forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Исходный список -> ");
        printList(stringLinkedList);
        List reverseList = getReverseList(stringLinkedList);
        printList(reverseList);
    }
}
