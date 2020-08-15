package ua.nure.lytovchenko.task4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo {
    private static final InputStream STD_IN = System.in;
    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) throws IOException {

        System.out.println("=================== PART1");
        System.setIn(new ByteArrayInputStream(
                "asdf^Latn^Cyrl^stop^"
                        .replace("^", System.lineSeparator()).getBytes(ENCODING)));
        Part1.main(args);
        System.setIn(STD_IN);

        System.out.println("=================== PART2");
        System.setIn(new ByteArrayInputStream(
                "table ru^table en^key locale name^apple ru^stop^"
                        .replace("^", System.lineSeparator()).getBytes(ENCODING)));
        Part2.main(args);
        System.setIn(STD_IN);

        System.out.println("=================== PART3");
        System.setIn(new ByteArrayInputStream(
                "table ru^table en^key locale name^apple ru^stop^"
                        .replace("^", System.lineSeparator()).getBytes(ENCODING)));
        Part3.main(args);
        System.setIn(STD_IN);
        Part4.main(args);
        Part5.main(args);
    }

}
