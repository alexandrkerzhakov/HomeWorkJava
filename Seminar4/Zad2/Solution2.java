package GeekBrains.Seminar4.Zad2;

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

public class Solution2 {
    public static Logger logger = Logger.getLogger(Solution2.class.getName());
    public static SimpleFormatter simpleFormatter = new SimpleFormatter();
    public static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("D:\\Seminar4\\Zad2\\log.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static int getNumber() {
        int n = new Random().nextInt(101);
        return n;
    }

    public static int[] getArray() {
        int[] array;
        int size;
        System.out.print("Введите длину массива - > ");
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = getNumber();
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("Выводим элементы массива на экран -> ");
        for (Integer value : array) {
            System.out.print(value + " ");
        }
    }

    public static void getSort(int[] array) throws IOException {
        logger.addHandler(fileHandler);
        fileHandler.setFormatter(simpleFormatter);
        int front = array.length;
        while (front > 0) {
            swap(array, front);
            front--;
        }
    }

    public static void swap(int[] array, int front) throws IOException {
        logger.setLevel(Level.ALL);
        logger.info("Состояние массива до: " + Arrays.toString(array));
        for (int i = 0; i < front - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        logger.info("Состояние массива после: " + Arrays.toString(array));
    }

    public static void main(String[] args) throws IOException {
        int[] arr = getArray();
        printArray(arr);
        getSort(arr);
        System.out.println();
        printArray(arr);
    }
}
