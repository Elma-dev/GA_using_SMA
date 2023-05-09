package dev.elma;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        Chromosome gene = new Chromosome(10);
        System.out.println(gene.toString());
         */

        GNA gna = new GNA(5, 5);

        for(int i=0;i<50;i++){
            gna.sortPopulation();
            gna.crossover();
            if(Math.random()<0.5)
                gna.mutation();
            gna.getPopulation().forEach(c-> System.out.println(c.toString()));
            System.out.println("-------high fit : "+gna.getHighFit()+" --------");
            if(gna.getHighFit()==5) break;

        }

    }
}