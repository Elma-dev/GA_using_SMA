package dev.elma;

import java.util.Arrays;

public class GnaStringMain {
    public static void main(String[] args) {
        /*
        ChromosomeStr chromosomeStr=new ChromosomeStr(4);
        System.out.println(chromosomeStr);

        System.out.println(Math.abs('b'-'a'));

         */

        String target="hello";

        GNAStr gnaStr=new GNAStr(10,target);
        for(int i=0;i<30;i++) {

            gnaStr.sortPopulation();
            gnaStr.getPopulation().forEach(c -> {
                System.out.println(c);
            });
            System.out.println();
            if(Arrays.compare(gnaStr.population.get(0).getGenes(),target.toCharArray())==0){
                break;
            }
            gnaStr.crossover();
            if(Math.random()<0.5)
                gnaStr.mutation();
            System.out.println("-----------------------------------------------");
        }
    }
}
