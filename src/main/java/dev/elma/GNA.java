package dev.elma;

import java.util.*;

public class GNA{
    private ArrayList<Chromosome> population;
    private int sizeChromosome;
    public GNA(int sizeOfPopulation,int sizeChromosome){
        this.sizeChromosome=sizeChromosome;
        population =new ArrayList<>();
        for(int i=0;i<sizeOfPopulation;i++)
            population.add(new Chromosome(sizeChromosome));
    }

    ArrayList<Chromosome> getPopulation(){
        return population;
    }

    public ArrayList<Chromosome> sortPopulation(){
        Collections.sort(population,Collections.reverseOrder());
        return population;
    }

    public void crossover(){
        int crosPoint=new Random().nextInt(sizeChromosome-2)+1;

        int genes1[]=new int[sizeChromosome];
        int genes2[]=new int[sizeChromosome];

        for(int i=0;i<sizeChromosome;i++){
            genes1[i]=population.get(0).getGenes()[i];
            genes2[i]=population.get(1).getGenes()[i];
        }

        Chromosome childChromo1=new Chromosome(genes1);
        Chromosome childChromo2=new Chromosome(genes2);

        for(int i=0;i<crosPoint;i++){
            childChromo1.getGenes()[i]=population.get(1).getGenes()[i];
            childChromo2.getGenes()[i]=population.get(0).getGenes()[i];
        }
        System.out.println(crosPoint);
        System.out.println(childChromo1.toString());
        System.out.println(childChromo2.toString());

    }

}
