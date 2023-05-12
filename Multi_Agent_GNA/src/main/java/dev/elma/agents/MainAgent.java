package dev.elma.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
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
    private AID[] agents;
    @Override
    protected void setup() {
        agentFitness=new HashMap<>();
        populationSize =(int) this.getArguments()[0];
        ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
        dfAgentDescription=new DFAgentDescription();
        dfService=new ServiceDescription();
        dfService.setType("AnalyseAgents");
        dfAgentDescription.addServices(dfService);


        parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                for(int i=0;i<populationSize;i++){
                    try {
                        AgentController newAgent = getContainerController().createNewAgent("agent"+i,"dev.elma.agents.ChromoAgent",new Object[]{"Agent"+i});
                        newAgent.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        });


        parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                getAllAgents();
                ACLMessage message=new ACLMessage();
                for(int i=0;i<agents.length;i++){
                    message.setContent("informations");
                    message.addReceiver(agents[i]);
                    send(message);
                    ACLMessage receive = receive();
                    if(receive!=null){
                        Double f =Double.parseDouble( receive.getContent().split(":")[1]);
                        agentFitness.put(receive.getSender(),f);

                    }

                }
            }
        });




        this.addBehaviour(parallelBehaviour);
    }

    public void getAllAgents(){
        try {
            DFAgentDescription[] search = DFService.search(this, dfAgentDescription);
            agents=new AID[search.length];
            for(int i=0;i<search.length;i++){
                agents[i]=search[i].getName();
            }
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
    }

}
