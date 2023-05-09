package dev.elma.agents;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

import java.lang.reflect.Array;
import java.util.Random;

public class ChromoAgent extends Agent {
    private int genes[];
    private int fitness;

    @Override
    protected void setup() {
        genes=new int[5];
        fitness=0;
        this.generateGenes();
    }

    private void generateGenes(){
        for(int i=0;i<genes.length;i++){
            genes[i]= new Random().nextInt(2);
            fitness+=genes[i];
        }
    }

    private ACLMessage sendInfoMainAgent(){
        ACLMessage message = new ACLMessage();

    }
}
