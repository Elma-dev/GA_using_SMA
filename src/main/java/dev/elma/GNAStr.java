package dev.elma;

import java.util.*;

public class GNAStr {
    List<ChromosomeStr> population;
    String target;
    public GNAStr(int sizePopulation,String target){
        population=new ArrayList<>(sizePopulation);
        this.target=target;
        for(int i=0;i<sizePopulation;i++){
            population.add(new ChromosomeStr(target.length()));
            population.get(i).calculateFitness(target);
        }
    }

    public List<ChromosomeStr> getPopulation() {
        return population;
    }

    public List<ChromosomeStr> sortPopulation(){
        Collections.sort(this.population,Collections.reverseOrder());
        return population;
    }

    public void crossover(){
        int crossPoint=new Random().nextInt(target.length()-2)+1;
        char genes1[]=new char[target.length()];
        char genes2[]=new char[target.length()];
        for(int i=0;i<target.length();i++){

            genes1[i]=population.get(0).getGenes()[i];
            genes2[i]=population.get(1).getGenes()[i];
        }

        ChromosomeStr childChromo1=new ChromosomeStr(genes1);
        childChromo1.calculateFitness(target);
        ChromosomeStr childChromo2=new ChromosomeStr(genes2);
        childChromo2.calculateFitness(target);


        for(int i=0;i<crossPoint;i++){
            char c=population.get(1).getGenes()[i];
            population.get(1).getGenes()[i]=population.get(0).getGenes()[i];
            population.get(0).getGenes()[i]=c;
        }

        population.get(0).calculateFitness(target);
        population.get(1).calculateFitness(target);

    }
    List<ChromosomeStr> mutation(){
        int i=new Random().nextInt(target.length());
        int j=new Random().nextInt(target.length());
        char genes1[]=population.get(0).getGenes();
        char genes2[]=population.get(1).getGenes();



        population.get(0).getGenes()[i]= target.toCharArray()[i] != genes1[i] ?(char) (genes1[i]+(target.toCharArray()[i] - genes1[i])) : genes1[i];
        population.get(1).getGenes()[j]= target.toCharArray()[j] != genes2[j] ?(char) (genes2[j]+(target.toCharArray()[j] - genes2[j])) : genes2[j];

        population.get(0).calculateFitness(target);
        population.get(1).calculateFitness(target);

        return this.getPopulation();
    }
}
