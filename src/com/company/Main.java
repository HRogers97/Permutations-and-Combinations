package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Test permutations
        System.out.println("PERMUTATIONS");
        System.out.println("------------");

        Permuter<Integer> intPerm;
        Permuter<String> strPerm;

        intPerm= new Permuter<>(Arrays.asList(1,2,3));
        System.out.println("3-Permutation [1,2,3]: " + intPerm.generateAll());

        intPerm = new Permuter<>(Arrays.asList(2,4,13), 2);
        System.out.println("2-Permutation [2,4,13]: " + intPerm.generateAll());

        strPerm = new Permuter<>(Arrays.asList("Apples", "Oranges", "Bananas", "Cherries", "Lemons", "Peaches"), 4);
        System.out.println("Fruit 4-Permutations (Limit 5): " + strPerm.generateSome(5));

        System.out.println("\n");

        // Test Combinations
        System.out.println("Combinations");
        System.out.println("------------");

        Combiner<Integer> intComb;
        Combiner<String> strComb;

        intComb = new Combiner<>(Arrays.asList(1,2,3), 2);
        System.out.println("2-Combinations [1,2,3]: " + intComb.generateAll());

        strComb = new Combiner<>(Arrays.asList("Apples", "Oranges", "Bananas", "Cherries", "Lemons", "Peaches"), 4);
        System.out.println("Fruit Combinations (limit 5): " + strComb.generateSome(5));
    }
}
