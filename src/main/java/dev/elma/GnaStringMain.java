package dev.elma;

public class GnaStringMain {
    public static void main(String[] args) {
        /*
        ChromosomeStr chromosomeStr=new ChromosomeStr(4);
        System.out.println(chromosomeStr);

        System.out.println(Math.abs('b'-'a'));

         */

        GNAStr gnaStr=new GNAStr(200,"abc");
        for(int i=0;i<1000;i++) {

            gnaStr.sortPopulation().forEach(c -> {
                System.out.println(c);
            });
            gnaStr.crossover();

            gnaStr.getPopulation().forEach(c -> {
                System.out.println(c);
            });
            System.out.println("-----------------------------------------------");
        }
    }
}
