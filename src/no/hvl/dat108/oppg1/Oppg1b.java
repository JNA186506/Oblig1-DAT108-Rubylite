package no.hvl.dat108.oppg1;

import java.util.function.BinaryOperator;

public class Oppg1b {
    public static void main(String[] args) {
        BinaryOperator<Integer> addere = (a,b) -> a + b;
        int sum = beregn(1,2,addere);
        System.out.println(sum);

        BinaryOperator<Integer> storsteAv = (a,b) -> Math.max(a,b);
        System.out.println(beregn(1,2,storsteAv));

        BinaryOperator<Integer> absDifferanse = (a,b) -> Math.abs(a-b);
        System.out.println(beregn(-3,5,absDifferanse));
    }

    public static int beregn(int a, int b, BinaryOperator<Integer> fu) {
        return fu.apply(a, b);
    }
}