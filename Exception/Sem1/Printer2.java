package GeekBrains.Exception.Sem1;

import java.util.Arrays;

class Answer2 {
    public int[] subArrays(int[] a, int[] b){
        int[] res = new int[0];
        // Введите свое решение ниже
        if (a.length == b.length) {
            res = new int[a.length];
            for (int i = 0; i < res.length; i++) {
                if (a[i] > b[i]) {
                    res[i] = a[i] - b[i];
                }
                else {
                    res[i] = b[i] - a[i];
                }
            }
        }
        else {
            res = new int[1];
            res[0] = 0;
        }
        return res;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer2{
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{4, 5, 6, 7};
            b = new int[]{6, 2, 3};
        }
        else{
            a = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            b = Arrays.stream(args[1].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Answer2 ans = new Answer2();
        String itresume_res = Arrays.toString(ans.subArrays(a, b));
        System.out.println(itresume_res);
    }
}
