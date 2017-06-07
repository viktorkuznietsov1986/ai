package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 */
public abstract class VacuumCleanerModel {

    protected VacuumWorld world;
    protected Position position;

    public VacuumCleanerModel(VacuumWorld world) {
        this.world = world;
    }

    public Percept getPercept() {
        return new Percept() {
            @Override
            public boolean isDirty() {
                return world.isSectorDirty(position);
            }

            @Override
            public Position getPosition() {
                return position;
            }
        };
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
