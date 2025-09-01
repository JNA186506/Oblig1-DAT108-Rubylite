package no.hvl.dat108.oppg3;

import no.hvl.dat108.oppg2.Ansatt;
import no.hvl.dat108.oppg2.Kjonn;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Oppg3 {

    public static void main(String[] args) {
        List<Ansatt> ansatte = List.of(
                new Ansatt("Per", "Persen", Kjonn.MANN, "Regnskapsfører", 600000),
                new Ansatt("Anne", "Lise", Kjonn.KVINNE, "Advokat", 800000),
                new Ansatt("Arne", "Lise", Kjonn.ANDRE, "Advokatfullmektig", 900000),
                new Ansatt("Kari", "Nordmann", Kjonn.KVINNE, "Økonomisjef", 1200000),
                new Ansatt("Ola", "Olsen", Kjonn.MANN, "Avdelingsleder", 950000),
                new Ansatt("Siri", "Johansen", Kjonn.KVINNE, "Sjef", 880000),
                new Ansatt("Jonas", "Berg", Kjonn.MANN, "IT-konsulent", 720000),
                new Ansatt("Maria", "Hansen", Kjonn.KVINNE, "Markedsfører", 650000),
                new Ansatt("Ali", "Khan", Kjonn.MANN, "Systemutvikler", 500000),
                new Ansatt("Eva", "Lund", Kjonn.KVINNE, "Sekretær", 500000)
        );
        
        //a)
        System.out.println("A)");
        Stream<String> aStream = ansatte.stream()
                .map(Ansatt::getEtternavn);
        aStream.forEach(System.out::println);
        
        //b)
        System.out.println("B)");
        Predicate<Ansatt> kvinneFilter = a -> a.getKjonn() == Kjonn.KVINNE;
        int antallKvinner = (int) ansatte.stream()
        		.filter(kvinneFilter)
        		.count();
        System.out.println(antallKvinner);
        
        //c)
        System.out.println("C)");
        double snittLonnKvinner = averageLonn(ansatte, kvinneFilter);
        System.out.println(snittLonnKvinner);
        
        //d)
        System.out.println("D)");
        ansatte.stream()
                .filter(a -> a.getStilling().toLowerCase().contains("sjef"))
                .forEach(a -> a.setAarslonn(a.getAarslonn() * 1.07));
        printAnsattePredikat(ansatte, a -> a.getStilling().toLowerCase().contains("sjef"));

        //e)
        System.out.println("E)");
        boolean over800k = ansatte.stream()
                .anyMatch(a -> a.getAarslonn() > 800000);
        System.out.println(over800k);
        
        //f)
        System.out.println("F)");
        ansatte.forEach(System.out::println);
        
        //g)
        System.out.println("G)");
//        Map<Double, List<Ansatt>> resultat = ansatte.stream() //Oppretter en HashMap av ansatte
//                .collect(groupingBy(Ansatt::getAarslonn)); //Putter de ansatte inn i en Map med lønn som nøkkel og ansatt som verdi
//        List<Ansatt> minstLonnede = resultat.entrySet().stream()
//                .min(Comparator.comparing(Map.Entry::getKey)) //finner de minste nøklene, altså de med den minste lønnen
//                .map(Map.Entry::getValue)
//                .orElse(Collections.emptyList()); //inn i liste
//        minstLonnede.forEach(System.out::println);

        Optional<Ansatt> minstLonnede1 = ansatte.stream()
                    .min(Comparator.comparing(Ansatt::getAarslonn))
                    .stream().findAny();

        minstLonnede1.ifPresent(System.out::println);

        //h)
        System.out.println("H)");
        IntPredicate delbarPaa3eller5 = x -> x % 3 == 0 || x % 5 == 0;
        int delbarList = IntStream.rangeClosed(1,1000)
                    .filter(delbarPaa3eller5)
                    .sum();
        System.out.println("Summen av alle delbare mellom 1 og 1000 er: " + delbarList);
        
    }
    
    //d) hjelpemetode
    private static void printAnsattePredikat(List<Ansatt> ansatte, Predicate<Ansatt> filter) {
        ansatte.stream()
                .filter(filter)
                .forEach(System.out::println);
    }
    
    //c) hjelpemetode
    private static double averageLonn(List<Ansatt> ansatte, Predicate<Ansatt> filter) {
        return ansatte.stream()
                .filter(filter)
                .mapToDouble(Ansatt::getAarslonn)
                .average()
                .orElse(0.0);
    }

}
