package dev.elma;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.StaleProxyException;

public class AgentContainer {
    public static void main(String[] args) throws StaleProxyException {
        Runtime instance = Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        jade.wrapper.AgentContainer agentContainer = instance.createAgentContainer(profile);
        agentContainer.createNewAgent("king","dev.elma.agents.MainAgent",new Object[]{10});
    }
}
