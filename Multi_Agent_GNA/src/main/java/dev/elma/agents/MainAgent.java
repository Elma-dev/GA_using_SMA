package dev.elma.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

import java.util.HashMap;
import java.util.List;

public class MainAgent extends Agent {
    private HashMap<AID,Double> agentFitness;
    @Override
    protected void setup() {
        this.addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                AID sender = receive().getSender();
                String content = receive().getContent();
                System.out.println(sender.getLocalName()+" : "+content);
            }
        });
    }
}
