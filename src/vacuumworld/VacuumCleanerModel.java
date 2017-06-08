package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 */
public abstract class VacuumCleanerModel {

    protected VacuumWorld world;
    protected Position position;

    public VacuumCleanerModel(VacuumWorld world, Position position) {

        this.world = world;
        this.position = position;
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

            @Override
            public int getNumberOfCleanCells() {
                return world.getNumberOfCleanCells();
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
    void go(Direction direction) throws CantGoException {
        Position p = getPosition(direction);

        if (world.isSectorAvailable(p)) {
            position = p;
        }
        else {
            throw new CantGoException("go: cannot go by the following direction: " + direction);
        }

    }

    boolean cango(Direction direction) {
        Position p = getPosition(direction);
        return world.isSectorAvailable(p);
    }

    private Position getPosition(Direction direction) {
        int x = position.getX();
        int y = position.getY();

        switch (direction) {
            case UP:
                --y;
                break;
            case DOWN:
                ++y;
                break;
            case LEFT:
                --x;
                break;
            case RIGHT:
                ++x;
                break;
        }

        return new Position(x, y);
    }

    /**
     * Do nothing.
     */
    abstract void idle();
}
