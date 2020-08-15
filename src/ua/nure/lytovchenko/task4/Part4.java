package ua.nure.lytovchenko.task4;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part4 {
    public static void main(String[] args) throws IOException {
        try (FileWriter fileWriter = new FileWriter("part4.txt")) {
            SecureRandom secureRandom = new SecureRandom();
            for (int i = 0; i < 9; i++) {
                fileWriter.write(secureRandom.nextInt(50) + " ");
            }
            fileWriter.write(Integer.toString(secureRandom.nextInt(50)));
        }
        List<String> list;
        List<Integer> listInt;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("part4.txt"), StandardCharsets.ISO_8859_1))) {
            String line = reader.readLine();
            list = Arrays.asList(line.split(" "));
        }
        System.out.println("input ==> " + String.join(" ", list));
        listInt = list.stream().distinct().map(Integer::parseInt).collect(Collectors.toList());
        quickSort(listInt, 0, listInt.size() - 1);
        try (FileWriter fileWriter2 = new FileWriter("part4_sorted.txt")) {
            for (int i = 0; i < listInt.size() - 1; i++) {
                fileWriter2.write(listInt.get(i) + " ");
            }
            fileWriter2.write(listInt.get(listInt.size() - 1).toString());
        }
        System.out.println("output ==> " + String.join(" ", listInt.stream()
                                                                     .map(Object::toString)
                                                                     .collect(Collectors.toList())));
    }


    public static void quickSort(List<Integer> list, int low, int high) {
        if (list.isEmpty()) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int opora = list.get(middle);
        int i = low;
        int j = high;
        while (i <= j) {
            while (list.get(i) < opora) {
                i++;
            }
            while (list.get(j) > opora) {
                j--;
            }
            if (i <= j) {
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(list, low, j);
        }
        if (high > i) {
            quickSort(list, i, high);
        }
    }
}
