package vacuumworld;

/**
 * Created by evikuzn on 6/7/2017.
 */
public class VacuumWorldFactory {
    private static VacuumWorldFactory ourInstance = new VacuumWorldFactory();

    public static VacuumWorldFactory getInstance() {
        return ourInstance;
    }

    private VacuumWorldFactory() {
    }

    /**
     * Creates the simpe world with 2 locations.
     * First location is dirty.
     * @return
     */
    public VacuumWorld newSimpleWorld() {
        boolean[][] configuration = new boolean[1][2];
        configuration[0][0] = true;
        return new VacuumWorld(configuration);
    }
}
