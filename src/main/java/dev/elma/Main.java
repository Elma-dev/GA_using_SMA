package dev.elma;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        Chromosome gene = new Chromosome(10);
        System.out.println(gene.toString());
         */

        GNA gna = new GNA(10, 10);

        gna.getPopulation().forEach(c-> System.out.println(c.toString()));
        System.out.println("-------------------------------------");
        gna.sortPopulation().forEach(c-> System.out.println(c.toString()));
        System.out.println("--------------------------------------");
        gna.crossover();
        System.out.println("-------------------------------------");
        gna.getPopulation().forEach(c-> System.out.println(c.toString()));
        System.out.println("---------------------------------------");
        gna.mutation().forEach(c->System.out.println(c.toString()));


    }
}