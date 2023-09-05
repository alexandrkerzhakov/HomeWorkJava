package GeekBrains.Exception.Sem3;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
    Фамилия Имя Отчество дата рождения номер телефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству.
Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои.
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
    в него в одну строку должны записаться полученные данные, вида <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */

import GeekBrains.Exception.Sem3.exception.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String fioRegEx = "\\b[A-Z]{1}\\w+\\b";
    private static Pattern fioPattren = Pattern.compile(fioRegEx, Pattern.MULTILINE);

    private static String birthDateRegEx = "\\b\\d{1,2}\\.\\d{1,2}\\.\\d{4}\\b";
    private static Pattern birthDatePattern = Pattern.compile(birthDateRegEx, Pattern.MULTILINE);

    private static String numberPhoneRegEx = "\\b\\d{6,13}\\b";
    private static Pattern numberPhonePattern = Pattern.compile(numberPhoneRegEx, Pattern.MULTILINE);

    private static String sexRegEx = "\\bm|f\\b";
    private static Pattern sexPattern = Pattern.compile(sexRegEx, Pattern.MULTILINE);

    private static String firstName = "";
    private static String secondName = "";
    private static String lastName = "";
    private static String birthDate = "";
    private static String numberPhone = "";
    private static String sex = "";
    private static int counterGeneral = 0;
    private static int counterFIO = 0;

    private static boolean isFIO = false;
    private static boolean isFirstName = false;
    private static boolean isSecondName = false;
    private static boolean isLastName = false;
    private static boolean isBirthDate = false;
    private static boolean isNumberPhone = false;
    private static boolean isSex = false;

    public static String inputRequest() throws IOException {
        String[] res = getRandomArrayWithParam();
        String inputMask = String.join(" ", Arrays.stream(res).toList());
        System.out.println("Введите данные по заданным параметрам через пробел (очередность не важна) -> " + inputMask);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String lineWithParam = bufferedReader.readLine();
        bufferedReader.close();
        return lineWithParam;
    }

    public static String[] getRandomArrayWithParam() {
        String[] defaultArray = {"Фамилия Имя Отчество", "Дата рождения", "Номер телефона", "Пол"};
        String[] result = new String[defaultArray.length];
        List<Integer> indexList = new ArrayList<>();

        int iterator = 0;
        while (true) {
            int candidateIndex = new Random().nextInt(defaultArray.length);
            if (!indexList.contains(candidateIndex)) {
                indexList.add(candidateIndex);
                result[iterator] = defaultArray[candidateIndex];
                iterator++;
            }
            if (indexList.size() == result.length) {
                break;
            }
        }
        return result;
    }

    public static void parseLine(String line) throws Exception {
        List<String> inputList = new ArrayList<>();
        List<String> beforeParseList = new ArrayList<>();
        List<String> diffList = new ArrayList<>();

        for (String word : line.split(" ")) {
            inputList.add(word);

            Matcher fioMatcher = fioPattren.matcher(word);
            Matcher birthDateMatcher = birthDatePattern.matcher(word);
            Matcher numberPhoneMatcher = numberPhonePattern.matcher(word);
            Matcher sexMatcher = sexPattern.matcher(word);

            if (fioMatcher.find()) {
                if (isFIO) {
                    continue;
                }
                String componentfio = fioMatcher.group().trim();
                beforeParseList.add(componentfio);
                counterFIO++;
                counterGeneral++;

                if (counterFIO == 1) {
                    firstName = componentfio;
                    isFirstName = true;
                }

                if (counterFIO == 2) {
                    secondName = componentfio;
                    isSecondName = true;
                }

                if (counterFIO == 3) {
                    lastName = componentfio;
                    isLastName = true;
                }

                if (counterFIO == 3 && isFirstName && isSecondName && isLastName) {
                    isFIO = true;
                }

            } else if (birthDateMatcher.find()) {
                if (isBirthDate) {
                    continue;
                }
                isBirthDate = true;
                birthDate = birthDateMatcher.group().trim();
                beforeParseList.add(birthDate);
                counterGeneral++;
            } else if (numberPhoneMatcher.find()) {
                if (isNumberPhone) {
                    continue;
                }
                isNumberPhone = true;
                numberPhone = numberPhoneMatcher.group().trim();
                beforeParseList.add(numberPhone);
                counterGeneral++;
            } else if (sexMatcher.find()) {
                if (isSex) {
                    continue;
                }
                isSex = true;
                sex = sexMatcher.group().trim();
                beforeParseList.add(sex);
                counterGeneral++;
            }
        }

        if (counterGeneral == 6 && isFIO && isBirthDate && isNumberPhone && isSex && inputList.size() == beforeParseList.size()) {
            System.out.println("Данные введены в полном объеме и они корректны");
            writeDataInFile();
        } else {
            System.out.println("Имеются ошибки!");
            System.out.println("Список введенных значений -> "
                    + inputList + ", необходимо ввести минимум значений - 6, введено -> "
                    + inputList.size());
            System.out.println("Список полученных значений после парсинга -> "
                    + beforeParseList + ", необходимо ввести 6 корректных значений, введено -> "
                    +  beforeParseList.size());

            diffList = getDiffListWithTwoList(inputList, beforeParseList);
            System.out.println("Список некорректных значений -> " + diffList + ", их количество -> " + diffList.size());
            isParam();
        }
    }

    public static void writeDataInFile() throws IOException {
        Path currentPath = Paths.get("Your path");
        Path pathFile = Paths.get(currentPath.toString() + "\\" + secondName + ".txt");
        FileWriter fileWriter = null;
        String writeLine = firstName + " " + secondName + " " + lastName + " " + birthDate + " " + numberPhone + " " + sex;

        Optional<String> optionalFile = Files
                .walk(currentPath)
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .map(path -> path.toString().split("\\.")[0])
                .filter(fileName -> fileName.equals(secondName))
                .findAny();

        if (optionalFile.isPresent()) {
            try {
                fileWriter = new FileWriter(pathFile.toFile(), true);
                fileWriter.write("\n" + writeLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                fileWriter = new FileWriter(pathFile.toFile());
                fileWriter.write(writeLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileWriter.close();
    }

    public static void isParam() throws Exception {
        if (!isFirstName) {
            throw new FirstNameException();
        }

        if (!isSecondName) {
            throw new SecondNameException();
        }

        if (!isLastName) {
            throw new LastNameException();
        }

        if (!isBirthDate) {
            throw new BirthDateException();
        }

        if (!isNumberPhone) {
            throw new NumberPhoneException();
        }

        if (!isSex) {
            throw new SexException();
        }
    }

    public static List<String> getDiffListWithTwoList(List<String> listOne, List<String> listTwo) {
        List<String> diffList = new ArrayList<>();
        int i = 0;
        if (!listOne.isEmpty() && !listTwo.isEmpty()) {
            for (String value : listOne) {
                if (!value.equals(listTwo.get(i))) {
                    diffList.add(value);
                    i--;
                }
                i++;
            }
        } else diffList.addAll(listOne);
        return diffList;
    }

    public static void main(String[] args) throws Exception {
        parseLine(inputRequest());
    }
}
