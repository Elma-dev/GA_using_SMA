# GA_using_SMA
# In This Repository
I use Java to create a genetic algorithm in this repository. To improve the performance of this algorithm, I also utilize a system multi-agent.
# GNA Concepts
there are three main concepts in GNA :
* Chromosome : set of genes (solution)
* Population : set of chromosome (solutions)
* fitness : each chromosome has a fitness value  (the ability of an individual to compete with other individuals)
![image](https://user-images.githubusercontent.com/67378945/236702757-7abfaeb2-5d93-49d1-bb0a-298d1e61f934.png)

example of fitness :

   ![image](https://user-images.githubusercontent.com/67378945/236702776-e91e5d91-54c6-41f6-9629-631bef6c79e2.png)
# How GNA Work 
1. Evaluate each choromosome
2. Select choromosomes with hight fitness, 
The idea of selection phase is to select the fittest individuals and let them pass their genes to the next generation.
3. Crossover the select chromosomes and gnerate new chromosome 

![image](https://user-images.githubusercontent.com/67378945/236703064-e88fbf55-ca46-48fc-bf3b-7288314ff920.png)
![image](https://user-images.githubusercontent.com/67378945/236703169-3d2fe150-d6cc-43ec-92cc-141f82a368d0.png)


4. Mutation : Mutation helps to introduce new genetic diversity into the population and can help to prevent the algorithm from getting stuck in a local minimum.

![image](https://user-images.githubusercontent.com/67378945/236703075-391113f8-7fc7-422e-978d-a79d12d99047.png)

## Schema Gneral of GNA
![image](https://user-images.githubusercontent.com/67378945/236703227-da2f7f4c-4a15-4110-8d90-7f8f599f45da.png)

# Implementation 
## Selection function 
in this function all we need is sort the poputlation fitness and get the k chromo with the highest fitness 
```
   public ArrayList<Chromosome> sortPopulation(){
        Collections.sort(population,Collections.reverseOrder());
        return population;
    }
```
## Crossover function
```
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

        population.get(0).getFitness();
        population.get(1).getFitness();

    }
```
## Mutation function
```
   List<Chromosome> mutation(){
        int i=new Random().nextInt(sizeChromosome);
        int j=new Random().nextInt(sizeChromosome);
        int genes1[]=population.get(0).getGenes();
        int genes2[]=population.get(1).getGenes();

        genes1[i]= genes1[i]==1 ? 0 : 1;
        genes2[j]= genes2[j]==1 ? 0 : 1;

        population.get(0).getFitness();
        population.get(1).getFitness();

        return this.getPopulation();
    }
```
