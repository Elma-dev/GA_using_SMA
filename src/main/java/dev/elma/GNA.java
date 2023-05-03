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
    List<Chromosome> mutation(){
        int i=new Random().nextInt(sizeChromosome);
        int j=new Random().nextInt(sizeChromosome);
        int genes1[]=population.get(0).getGenes();
        int genes2[]=population.get(1).getGenes();

        System.out.println(population.get(0).getGenes()[i]+" "+population.get(1).getGenes()[j] +" before");
        genes1[i]= genes1[i]==1 ? 0 : 1;
        genes2[j]= genes2[j]==1 ? 0 : 1;
        System.out.println(population.get(0).getFitness()+" "+population.get(1).getFitness()+" after");
        System.out.println(i+""+j);

        return this.getPopulation();
    }

}
