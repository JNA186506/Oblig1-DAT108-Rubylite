package no.hvl.dat108.oppg2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Oppg2 {

    private Kjonn kjonn;
    public static void main(String[] args) {
        List<Ansatt> ansatte = List.of(new Ansatt("Per", "Persen", Kjonn.MANN,"Regnskapsfører", 600000),
                new Ansatt("Anne", "Lise", Kjonn.KVINNE, "Advokat", 800000),
                new Ansatt("Arne", "Lise", Kjonn.ANDRE, "Advokatfullmektig", 900000));

        Function<Ansatt, Double> oppgjor = a -> a.getAarslonn() + 100.0;
        lonnsoppgjor(ansatte, oppgjor);
        System.out.println();
        skrivUtAnsatte(ansatte);

        Function<Ansatt, Double> oppgjorProsent = a -> a.getAarslonn() * 1.05;
        lonnsoppgjor(ansatte, oppgjorProsent);
        System.out.println();
        skrivUtAnsatte(ansatte);

        Predicate<Ansatt> mannOppgjor = a -> a.getKjonn().equals(Kjonn.MANN);
        System.out.println();
        lonnsoppgjor(ansatte, oppgjorProsent, mannOppgjor);
        skrivUtAnsatte(ansatte, mannOppgjor);


    }

    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Double> lonnsFu) {
        for (Ansatt a : ansatte) {
           a.setAarslonn(lonnsFu.apply(a));
        }
    }

    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Double> lonnsFu,
                                     Predicate<Ansatt> kontraktFu) {
        for (Ansatt a : ansatte) {
            if (kontraktFu.test(a)) {
                a.setAarslonn(lonnsFu.apply(a));
            }
        }
    }

    private static void skrivUtAnsatte(List<Ansatt> ansatte) {
        for (Ansatt a : ansatte) {
            System.out.println(a.toString());
        }
    }

    private static void skrivUtAnsatte(List<Ansatt> ansatte, Predicate<Ansatt> kontraktFu) {
        for (Ansatt a : ansatte) {
            if (kontraktFu.test(a)) {
                System.out.println(a.toString());
            }
        }
    }
}
