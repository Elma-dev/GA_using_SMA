package dev.elma;

import java.util.Arrays;
import java.util.Random;

public class ChromosomeStr implements Comparable{
    private char[] genes;
    private int fitness;
    Random rnd=new Random();

    public ChromosomeStr(int geneSize) {
        this.genes=new char[geneSize];

        for(int i=0;i<geneSize;i++){
            int charIdx=rnd.nextInt(26)+97;
            genes[i]=(char)charIdx;
        }
    }
    public ChromosomeStr(char[] gene){
        genes =gene;
    }
    public int calculateFitness(String target){
        this.fitness=0;
        for(int i=0;i<genes.length;i++){
            fitness+=target.toCharArray()[i]-genes[i];
        }
        return this.fitness;
    }

    public char[] getGenes() {
        return genes;
    }

    public void setGenes(char[] genes) {
        this.genes = genes;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        return "ChromosomeStr{" +
                "genes=" + Arrays.toString(genes) +
                ", fitness=" + fitness +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        ChromosomeStr individual=(ChromosomeStr) o;

        if(this.fitness==0)
            return 1;
        if(individual.fitness==0)
            return -1;
        if (this.fitness>individual.fitness)
            return 1;
        else if(this.fitness<individual.fitness){
            return -1;
        }else
            return 0;
    }
}
