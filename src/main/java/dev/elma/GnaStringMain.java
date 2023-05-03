package dev.elma;

public class GnaStringMain {
    public static void main(String[] args) {
        /*
        ChromosomeStr chromosomeStr=new ChromosomeStr(4);
        System.out.println(chromosomeStr);

        System.out.println(Math.abs('b'-'a'));

         */

        GNAStr gnaStr=new GNAStr(10,"hello");
        for(int i=0;i<30;i++) {

            gnaStr.sortPopulation();
            if(gnaStr.getPopulation().get(0).getFitness()==0){
                break;
            }
            gnaStr.crossover();
            if(Math.random()<0.5)
                gnaStr.mutation();

            gnaStr.getPopulation().forEach(c -> {
                System.out.println(c);
            });

            System.out.println("-----------------------------------------------");
        }
    }
}
