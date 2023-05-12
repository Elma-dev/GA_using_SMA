package dev.elma.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainAgent extends Agent {
    private HashMap<AID,Double> agentFitness;
    private int populationSize;
    private DFAgentDescription dfAgentDescription;
    private ServiceDescription dfService;
    @Override
    protected void setup() {
        agentFitness=new HashMap<>();
        populationSize =(int) this.getArguments()[0];
        ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
        dfAgentDescription=new DFAgentDescription();
        dfService=new ServiceDescription();
        dfService.setType("AnalyseAgent");
        dfAgentDescription.addServices(dfService);

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
                try {
                    DFAgentDescription[] search = DFService.search(this.myAgent, dfAgentDescription);
                    for(int i=0;i<search.length;i++){
                        Iterator allServices=search[i].getAllServices();
                        while (allServices.hasNext()){
                            System.out.println(((DFAgentDescription)allServices.next()).getName());
                        }
                    }
                } catch (FIPAException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        this.addBehaviour(parallelBehaviour);
    }

}
