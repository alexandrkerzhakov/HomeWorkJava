package GeekBrains.Seminar4.Zad1;

/*
Дана строка sql-запроса ""select * from students where "".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {""name"":""Ivanov"", ""country"":""Russia"", ""city"":""Moscow"", ""age"":""null""}
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {

    public static String getWhere() {
        StringBuilder stringBuilder = new StringBuilder();
        String beginSql = "select * from students where ";
        stringBuilder.append(beginSql);

        String jsonLine = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\",\"age\":\"null\"}";

        Arrays.stream(jsonLine.split(","))
                .filter(s -> !s.contains("null"))
                .map(s -> s.replace(":", "=").replace("{", "").replace("\"", "").trim())
                .forEach(s -> stringBuilder.append(s + " and "));
        stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length()); // delete last and
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(getWhere());
    }
}
