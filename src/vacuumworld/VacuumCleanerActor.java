package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 * The model of actor for the vacuum cleaner.
 */
public interface VacuumCleanerActor {
    /**
     * Perform any action requested.
     * @param action : knows what to do in terms of vacuum world.
     */
    void perform(Action action);
}
