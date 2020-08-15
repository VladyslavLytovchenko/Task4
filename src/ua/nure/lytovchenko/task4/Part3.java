package ua.nure.lytovchenko.task4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part3 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input;
            while (true) {
                input = sc.nextLine();
                if ("stop".equalsIgnoreCase(input)) {
                    break;
                }
                String[] words = input.split(" ");
                if (words.length < 2) {
                    System.out.println("Incorrect input");
                    continue;
                }
                String lang = words[1];
                String word = words[0];
                try {
                    Locale locale = new Locale(lang);
                    ResourceBundle rb = ResourceBundle.getBundle("resources", locale);
                    System.out.println(rb.getString(word));
                } catch (java.util.MissingResourceException ex) {
                    System.out.println("Invalid input");
                }
            }
        }
    }
}
