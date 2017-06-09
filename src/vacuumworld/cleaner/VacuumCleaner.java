package vacuumworld.cleaner;

import vacuumworld.exceptions.CantGoException;
import vacuumworld.misc.Direction;
import vacuumworld.misc.Percept;
import vacuumworld.misc.Position;
import vacuumworld.world.VacuumWorld;

/**
 * Created by Viktor on 6/5/17.
 */
public abstract class VacuumCleaner {

    protected VacuumWorld world;
    protected Position position;
    private Position startPosition;

    /**
     * Ctor.
     * @param world the world where the cleaner is located.
     * @param position the actual position of the cleaner.
     */
    public VacuumCleaner(VacuumWorld world, Position position) {

        this.world = world;
        this.position = position;
        this.startPosition = position;
    }

    /**
     * Get start position of the cleaner.
     * @return the start position of the cleaner.
     */
    public Position getStartPosition() {
        return startPosition;
    }

    /**
     * Gets the actual percept.
     * @return the actual percept.
     */
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
    public abstract void suck();

    /**
     * Go at any direction in the world. If coming to bounds of the world, do nothing.
     * @param direction
     */
    public void go(Direction direction) throws CantGoException {
        Position p = getPosition(direction);

        if (world.isSectorAvailable(p)) {
            position = p;
        }
        else {
            throw new CantGoException("go: cannot go by the following direction: " + direction);
        }

    }

    /**
     * Checks whether it's possible to go at the following direction.
     * @param direction the desired direction.
     * @return true if it's possible to go at the following direction, false otherwise.
     */
    public boolean cango(Direction direction) {
        if (direction == Direction.NONE) {
            return false;
        }

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
    public abstract void idle();
}
