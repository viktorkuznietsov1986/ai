package vacuumworld;

/**
 * Created by evikuzn on 6/7/2017.
 */
public class Simulator {
    private VacuumCleanerModel cleaner;
    private Agent agent;
    private VacuumWorld world;
    private int timeSteps;


    public Simulator(VacuumCleanerModel cleaner, Agent agent, VacuumWorld world, int timeSteps) {
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

    public void start() {
        for (int i = 0; i < timeSteps; ++i) {
            agent.perform(cleaner.getPercept());
            world.generateRandormDirt();
        }
    }

    public int getPerformance() {
        return agent.getPerformance();
    }
}
