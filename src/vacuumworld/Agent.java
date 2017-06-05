package vacuumworld;

/**
 * Created by Viktor on 6/4/17.
 * Agent for vacuum cleaner in vacuum world.
 */
public interface Agent {
    /**
     * Perform a sucking action to clean up the dirt.
     */
    void suck();

    /**
     * Go at any direction in the world. If coming to bounds of the world, do nothing.
     * @param direction
     */
    void go(Direction direction);

    /**
     * Do nothing.
     */
    void idle();
}
