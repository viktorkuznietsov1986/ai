package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 */
public abstract class VacuumCleanerModel {
    protected int performance = 0;

    /**
     * Returns the gained performance.
     * @return the gained performance.
     */
    public int getPerformance() {
        return performance;
    }

    /**
     * Perform a sucking action to clean up the dirt.
     */
    abstract void suck();

    /**
     * Go at any direction in the world. If coming to bounds of the world, do nothing.
     * @param direction
     */
    void go(Direction direction) {
        if (cango(direction)) {
            updatePosition(direction);
        }
    }

    /**
     * Checks whether the vacuum cleaner can go towards the specified direction.
     * @param direction
     * @return true if vacuum cleaner can go, false otherwise.
     */
    abstract boolean cango(Direction direction);

    /**
     * Updates position according to the chosen direction.
     * @param direction
     */
    abstract void updatePosition(Direction direction);

    /**
     * Do nothing.
     */
    abstract void idle();
}
