package dev.elma;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;

public class AgentContainer {
    public static void main(String[] args) {
        Runtime instance = Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        jade.wrapper.AgentContainer agentContainer = instance.createAgentContainer(profile);

    }
}
