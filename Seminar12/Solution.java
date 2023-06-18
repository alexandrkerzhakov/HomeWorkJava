package GeekBrains.Seminar12;

import GeekBrains.KR.Toy;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static final String lineWithName =
            "Tom, 9001351690\n" +
                    "Jack, 9213671675\n" +
                    "Petr, 9129751686\n" +
                    "Petr, 9152301900\n" +
                    "Petr, 9021351695\n" +
                    "Ron, 9001375698\n" +
                    "Jack, 9055351550\n" +
                    "Tom, 9001381999\n" +
                    "Alex, 9009351666\n" +
                    "Jack, 9007351690\n" +
                    "Petr, 9003351690\n";

    public static Map<String, List<String>> getHashMap(String lineWithName) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        String[] fullArrayWithName = lineWithName.split("\n");
        for (String line : fullArrayWithName) {
            String[] arrayWithName = line.split(",");
            String name = arrayWithName[0].trim();
            String phone = arrayWithName[1].trim();
            if (!hashMap.containsKey(name)) {
                hashMap.put(name, new ArrayList<>(Collections.singleton(phone)));
            } else {
                hashMap.get(name).add(phone);
            }
        }
        return hashMap;
    }

    //    class
//
    public static Map<String, List<String>> getSort(Map<String, List<String>> hashMap) {
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        hashMap
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(element -> -element.getValue().size()))
                .forEach(e -> map.put(e.getKey(), e.getValue()));
        return map;
    }

    public static void printHashMap(Map<String, List<String>> hashMap) {
        for (Map.Entry<String, List<String>> pair : hashMap.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> hashMap = getHashMap(lineWithName);
        System.out.println("До сортировки по количеству телефонов -> ");
        printHashMap(hashMap);
        Map<String, List<String>> sortedByListSizeHashMap = getSort(hashMap);
        System.out.println("После сортировки по количеству телефонов -> ");
        printHashMap(sortedByListSizeHashMap);
    }
}


