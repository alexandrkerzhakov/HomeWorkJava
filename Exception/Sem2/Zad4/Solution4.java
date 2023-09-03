package GeekBrains.Exception.Sem2.Zad4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {
    public static String inputLine() throws IOException {
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите строку -> ");
            line = bufferedReader.readLine();
            if (line.isEmpty()) {
                throw new EmptyLineException();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args) throws IOException {
        inputLine();
    }
}
