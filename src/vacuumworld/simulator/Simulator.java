package vacuumworld.simulator;

import vacuumworld.cleaner.VacuumCleaner;
import vacuumworld.world.VacuumWorld;
import vacuumworld.agents.Agent;

/**
 * Created by evikuzn on 6/7/2017.
 * Simulator.
 */
public class Simulator {
    private VacuumCleaner cleaner;
    private Agent agent;
    private VacuumWorld world;
    private int timeSteps;


    /**
     * Ctor.
     * @param cleaner the vacuum cleaner.
     * @param agent the rational agent.
     * @param world the vacuum world.
     * @param timeSteps number of simulation steps.
     */
    public Simulator(VacuumCleaner cleaner, Agent agent, VacuumWorld world, int timeSteps) {
        if (cleaner == null)
            throw new IllegalArgumentException("cleaner cannot be null");

        if (agent == null)
            throw new IllegalArgumentException("agent cannot be null");

        if (world == null)
            throw new IllegalArgumentException("world cannot be null");

        if (timeSteps <= 0)
            throw new IllegalArgumentException("timeSteps should be positive integer");

        this.cleaner = cleaner;
        this.agent = agent;
        this.world = world;
        this.timeSteps = timeSteps;
    }

    /**
     * Start the simulation.
     */
    public void start() {
        for (int i = 0; i < timeSteps; ++i) {
            agent.perform(cleaner.getPercept());
            world.generateRandormDirt();
        }
    }

    /**
     * Get the performance after the simulation.
     * @return the performance after the simulation.
     */
    public int getPerformance() {
        return agent.getPerformance();
    }
}
