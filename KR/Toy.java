package GeekBrains.KR;

/*
Урок 2. Магазин игрушек (Java)
Напишите класс-конструктор у которого принимает минимум 3 строки, содержащие три поля id игрушки, текстовое название и частоту выпадения игрушки
Из принятой строки id и частоты выпадения(веса) заполнить минимум три массива.
Используя API коллекцию: java.util.PriorityQueue добавить элементы в коллекцию
Организовать общую очередь
Вызвать Get 10 раз и записать результат в файл
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.PriorityQueue;

public class Toy implements Comparable<Toy> {

    private static final String lineWithToy =
            "3, Tom, 15\n" +
                    "5, Jack, 10\n" +
                    "7, Jon, 5\n" +
                    "1, Petr, 20\n" +
                    "3, Vasya, 15\n" +
                    "4, Ron, 25\n" +
                    "6, Don, 30\n" +
                    "8, Bob, 40\n" +
                    "9, Alex, 50\n" +
                    "10, Sergey, 60\n" +
                    "2, Ivan, 35\n" +
                    "13, Konstantin, 45\n" +
                    "11, Denis, 55\n" +
                    "15, David, 45\n" +
                    "12, Andryu, 20\n" +
                    "14, Evgeniy, 50\n";

    private int id;
    private String name;
    private int frequency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Toy toy) {
        if (this.getFrequency() > toy.getFrequency()) {
            return 1;
        } else if (this.getFrequency() < toy.getFrequency()) {
            return -1;
        } else return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, frequency);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    public static PriorityQueue<Toy> getQueue(String lineWithToy) {
        PriorityQueue<Toy> priorityQueue = new PriorityQueue<>();
        String[] arrayWithToy = lineWithToy.split("\n");
        for (String line : arrayWithToy) {
            String[] arrayToy = line.split(",");
            int idToy = Integer.parseInt(arrayToy[0].trim());
            String nameToy = arrayToy[1].trim();
            int frequencyToy = Integer.parseInt(arrayToy[2].trim());
            priorityQueue.add(new Toy(idToy, nameToy, frequencyToy));
        }
        return priorityQueue;
    }

    public static void saveOnFileSelectionFromQueue(String filename) {
        PriorityQueue<Toy> priorityQueue = getQueue(lineWithToy);
        FileWriter writer;
        try {
            writer = new FileWriter(filename);
            for (int i = 0; i < 10; i++) {
                writer.write(String.valueOf(priorityQueue.remove()) + "\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        saveOnFileSelectionFromQueue("filename");
    }
}
