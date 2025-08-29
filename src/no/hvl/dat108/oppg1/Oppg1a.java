package no.hvl.dat108.oppg1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Oppg1a {
    public static void main(String[] args) {
        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

        Comparator<String> sammenligner = (a, b) -> Integer.valueOf(a).compareTo(Integer.valueOf(b));

        Collections.sort(listen,sammenligner);

        System.out.println(listen);
    }

}