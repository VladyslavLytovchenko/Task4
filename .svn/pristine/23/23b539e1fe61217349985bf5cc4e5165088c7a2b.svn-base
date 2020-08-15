package ua.nure.lytovchenko.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordContainer {

    public static void main(String[] args) {
        List<Word> list = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            String input = "";
            while (!input.contains("stop") && sc.hasNextLine()) {
                input = sc.nextLine();
                if(input.contains("stop")){
                    input = input.substring(0,input.indexOf("stop")+4);
                }
                String[] arr = input.split(" ");
                for (String s : arr) {
                    if (!list.contains(new Word(s))) {
                        list.add(new Word(s));
                    } else {
                        int index = list.indexOf(new Word(s));
                        Word w = list.get(index);
                        w.setFrequency(w.getFrequency()+1);
                        list.set(index, w);
                    }
                }
            }
        }
        list.remove(list.size()-1);
        Collections.sort(list);
        System.out.println(String.join("\n", list.stream()
                                                           .filter(x -> !"stop"
                                                           .equals(x.getText()))
                                                           .map(Word::toString)
                                                           .collect(Collectors.toList())));
    }
}
