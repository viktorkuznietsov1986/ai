package vacuumworld.simulator;

import vacuumworld.agents.Agent;
import vacuumworld.agents.SimpleWorldReflexAgent;
import vacuumworld.agents.SimpleWorldReflexAgentWithGoPenalty;
import vacuumworld.cleaner.VacuumCleaner;
import vacuumworld.cleaner.VacuumCleanerImpl;
import vacuumworld.misc.Position;
import vacuumworld.world.VacuumWorld;
import vacuumworld.world.VacuumWorldFactory;

/**
 * Created by Viktor on 6/8/17.
 */
public class SimpleWorldSimpleReflexAgentGoPenaltyRunner implements SimulationRunner {
    /**
     * Runs the simulation.
     */
    @Override
    public void run() {
        int score = 0;

        for (int i = 0; i < 2; ++i) {
            VacuumWorld world = VacuumWorldFactory.getInstance().newSimpleWorld();
            VacuumCleaner cleaner = new VacuumCleanerImpl(world, new Position(i, 0));
            Agent agent = new SimpleWorldReflexAgentWithGoPenalty(cleaner);
            Simulator simulator = new Simulator(cleaner, agent, world, 100);
            simulator.start();
            System.out.println("The agent's performance score for x = " + i + " is " + agent.getPerformance());
            score += agent.getPerformance();
        }

        score /= 2;

        System.out.println("The average performance score is: " + score);
    }
}
