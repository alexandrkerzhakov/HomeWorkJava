package GeekBrains.Exception.Sem1;

import java.util.Arrays;

class Answer3 {
    public int[] divArrays(int[] a, int[] b) {
        int[] res = new int[0];
        if (a.length == b.length) {
            res = new int[a.length];
            for (int i = 0; i < res.length; i++) {
                if (a[i] > 0 && b[i] > 0) {
                    if (a[i] > b[i]) {
                        res[i] = a[i] / b[i];
                    } else {
                        res[i] = b[i] / a[i];
                    }
                } else if (a[i] < b[i]) {
                    res[i] = a[i] / b[i];
                } else {
                    res[i] = b[i] / a[i];
                }
            }
        } else {
            res = new int[1];
            res[0] = 0;
        }
        return res;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer3 {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{10, 14, -6};
            b = new int[]{5, 7, -2};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        Answer3 ans = new Answer3();
        String itresume_res = Arrays.toString(ans.divArrays(a, b));
        System.out.println(itresume_res);
    }
}
