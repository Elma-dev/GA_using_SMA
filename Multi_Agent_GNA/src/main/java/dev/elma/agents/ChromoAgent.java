package dev.elma.agents;

import dev.elma.AgentContainer;
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
import jade.wrapper.ControllerException;

import java.lang.reflect.Array;
import java.util.Random;

public class ChromoAgent extends Agent {
    private int genes[];
    private int fitness;
    private ParallelBehaviour parallelBehaviour;
    private DFAgentDescription dfAgentDescription;
    private ServiceDescription serviceDescription;

    @Override
    protected void setup() {
        genes=new int[5];
        fitness=0;
        this.generateGenes();
        parallelBehaviour = new ParallelBehaviour();
        dfAgentDescription=new DFAgentDescription();
        dfAgentDescription.setName(this.getAID());

        serviceDescription=new ServiceDescription();
        serviceDescription.setName("chromosomeAgent");
        serviceDescription.setType("AnalyseAgents");

        dfAgentDescription.addServices(serviceDescription);




        parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                try {
                    DFService.register(myAgent,dfAgentDescription);
                } catch (FIPAException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        this.addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage receive = receive();
                if(receive!=null){
                    AID sender = receive.getSender();
                    String content = receive.getContent();
                    switch (content){
                        case "start":
                            generateGenes();
                            System.out.println("I'm start");
                            break;
                        case "informations":
                            try {
                                sendInfoMainAgent(sender);
                            } catch (Exception e) {e.printStackTrace();}
                            break;
                    }
                }
                else block();
            }
        });
    }

    private void generateGenes(){
        for(int i=0;i<genes.length;i++){
            genes[i]= new Random().nextInt(2);
            fitness+=genes[i];
        }
    }

    private void sendInfoMainAgent(AID aid) throws ControllerException {
        ACLMessage message = new ACLMessage(ACLMessage.CONFIRM);
        message.setContent("f:"+fitness);
        message.addReceiver(aid);
        send(message);
    }
}
