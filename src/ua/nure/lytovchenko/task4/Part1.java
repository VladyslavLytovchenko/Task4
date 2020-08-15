package ua.nure.lytovchenko.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            String input;
            String text = readFile();
            while (true) {
                input = sc.nextLine();
                if("stop".equalsIgnoreCase(input)){
                    break;
                }
                System.out.print(input + ": ");
                if ("Latn".equals(input)) {
                    System.out.println(find(text, Lang.ENG));
                } else if ("Cyrl".equals(input)) {
                    System.out.println(find(text, Lang.RU));
                }else{
                    System.out.println("Incorrect input");
                }
            }
        }
    }

    static String find(String text, Lang lang) {
        StringBuilder sb = new StringBuilder();
        Pattern engPattern = Pattern.compile("([A-Za-z]+)");
        Pattern ruPattern = Pattern.compile("([А-Яа-яёЁєЄЇїІі]+)");
        Matcher matcher = lang == Lang.ENG ? engPattern.matcher(text) : ruPattern.matcher(text);
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        return sb.toString().trim();
    }

    static String readFile() throws IOException {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("part1.txt"));
            res = new String(bytes, "cp1251");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}



