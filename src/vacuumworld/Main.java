package vacuumworld;

/**
 * Created by evikuzn on 6/7/2017.
 */
public class Main {
    public static void main(String[] args) {
        VacuumWorld world = VacuumWorldFactory.getInstance().newSimpleWorld();
        VacuumCleanerModel cleaner = new VacuumCleanerImpl(world, new Position(0,0));
        Agent agent = new SimpleWorldAgent(cleaner);
        Simulator simulator = new Simulator(cleaner, agent, world, 100);
        simulator.start();

        System.out.println("The agent's performance is: " + agent.getPerformance());
    }
}
