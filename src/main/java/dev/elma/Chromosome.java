package dev.elma;

import java.util.Arrays;
import java.util.Random;

public class Chromosome implements Comparable {
    private int genes[];
    private int fitness;

    public Chromosome(int size){
        this.genes =new int[size];
        for(int i=0;i<size;i++) {
            genes[i]=new Random().nextInt(2);
        }
        fitness=getFitness();
    }


    public Chromosome(int[] gene){
        genes =gene;
        fitness=getFitness();
    }

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = this.genes;
    }

    public int getFitness() {
        for(int i = 0; i< genes.length; i++){
            fitness+= genes[i];
        }
        return fitness;
    }

    @Override
    public String toString() {
        return "Gen: "+Arrays.toString(genes)+" f:"+fitness;
    }

    @Override
    public int compareTo(Object o) {
        Chromosome individual=(Chromosome) o;
        if (this.fitness>individual.fitness)
            return 1;
        else if(this.fitness<individual.fitness){
            return -1;
        }else
            return 0;
    }
}
