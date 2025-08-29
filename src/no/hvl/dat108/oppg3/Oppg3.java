package no.hvl.dat108.oppg3;

import no.hvl.dat108.oppg2.Ansatt;
import no.hvl.dat108.oppg2.Kjonn;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class Oppg3 {

    public static void main(String[] args) {
        List<Ansatt> ansatte = List.of(
                new Ansatt("Per", "Persen", Kjonn.MANN, "Regnskapsfører", 600000),
                new Ansatt("Anne", "Lise", Kjonn.KVINNE, "Advokat", 800000),
                new Ansatt("Arne", "Lise", Kjonn.ANDRE, "Advokatfullmektig", 900000),
                new Ansatt("Kari", "Nordmann", Kjonn.KVINNE, "Sjef", 1200000),
                new Ansatt("Ola", "Olsen", Kjonn.MANN, "Avdelingsleder", 950000),
                new Ansatt("Siri", "Johansen", Kjonn.KVINNE, "Sjef", 880000),
                new Ansatt("Jonas", "Berg", Kjonn.MANN, "IT-konsulent", 720000),
                new Ansatt("Maria", "Hansen", Kjonn.KVINNE, "Markedsfører", 650000),
                new Ansatt("Ali", "Khan", Kjonn.MANN, "Systemutvikler", 780000),
                new Ansatt("Eva", "Lund", Kjonn.KVINNE, "Sekretær", 500000)
        );
        //a)
        printAnsatteConditional(ansatte, Ansatt::getEtternavn);

        //c)
        Predicate<Ansatt> kvinneFilter = a -> a.getKjonn() == Kjonn.KVINNE;
        System.out.println(averageLonn(ansatte, kvinneFilter));

        printAnsattePredikat(ansatte, kvinneFilter);

        //d)
        ansatte.stream()
                .filter(a -> a.getStilling().equals("Sjef"))
                .forEach(a -> a.setAarslonn(a.getAarslonn() * 1.07));

        printAnsattePredikat(ansatte, a -> a.getStilling().equals("Sjef"));

        //e)
        System.out.println(ansatte.stream()
                .filter(a -> a.getAarslonn() > 800000));

        //f)
        ansatte.forEach(System.out::println);
        Map<Double, List<Ansatt>> resultat = ansatte.stream() //Oppretter en HashMap av ansatte
                .collect(groupingBy(Ansatt::getAarslonn)); //Putter de ansatte inn i en Map med lønn som nøkkel og ansatt som verdi

        //g) forslag 1
        List<Ansatt> minstLonnede = resultat.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getKey)) //finner de minste nøklene, altså de med den minste lønnen
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList()); //inn i liste
        //g) forslag 2
        List<Ansatt> minLonn = ansatte.stream()
                .filter(p -> p.getAarslonn() < 600000) //Kan godt finne minste lønn med mellomlagring av en verdi
                .toList();

        //f)
        System.out.println();
        minstLonnede.forEach(System.out::println);

        //g)
        IntPredicate delbarPaa3eller5 = x -> x % 3 == 0 || x % 5 == 0;

        List<Integer> delbarList = IntStream.rangeClosed(1,1000)
                    .filter(delbarPaa3eller5)
                    .boxed()
                    .toList();

    }

    //c)
    private static double averageLonn(List<Ansatt> ansatte, Predicate<Ansatt> filter) {
        return ansatte.stream()
                .filter(filter)
                .mapToDouble(Ansatt::getAarslonn)
                .average()
                .orElse(0.0);
    }

    //a)
    private static void printAnsattePredikat(List<Ansatt> ansatte, Predicate<Ansatt> filter) {
        ansatte.stream()
                .filter(filter)
                .forEach(System.out::println);
    }

    //b)
    private static void printAnsatteConditional(List<Ansatt> ansatte, Function<Ansatt, String> ansattFu) {
        ansatte.stream()
                .map(ansattFu)
                .forEach(System.out::println);
    }

}
