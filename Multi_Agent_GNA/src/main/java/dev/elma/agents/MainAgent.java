package dev.elma.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.util.HashMap;
import java.util.List;

public class MainAgent extends Agent {
    private HashMap<AID,Double> agentFitness;
    int populationSize;
    @Override
    protected void setup() {
        agentFitness=new HashMap<>();
        populationSize =(int) this.getArguments()[0];
        ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
        parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                for(int i=0;i<populationSize;i++){
                    try {
                        AgentController newAgent = getContainerController().createNewAgent("agent"+i,"dev.elma.agents.MainAgent",new Object[]{});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                for(AID iad:agents){
                    ACLMessage message=new ACLMessage();
                    message.addReceiver(iad);
                    message.setContent("start");
                }
            }
        });
        this.addBehaviour(parallelBehaviour);
    }

}
