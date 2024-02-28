package GeekBrains.JDK.Seminar3;

import java.util.Arrays;

public class CompareArray {
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1 == null || arr2 == null) {
            return arr1 == arr2;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        String[] arr3 = {"A", "B", "C"};
        String[] arr4 = {"A", "B", "C"};
        String[] arr5 = {"A", "C", "B"};

        System.out.println(compareArrays(arr1, arr2)); // true
        System.out.println(compareArrays(arr3, arr4)); // true
        System.out.println(compareArrays(arr3, arr5)); // false
    }

}