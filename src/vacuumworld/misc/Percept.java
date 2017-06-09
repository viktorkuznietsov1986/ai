package vacuumworld.misc;

/**
 * Created by Viktor on 6/4/17.
 * Interface to describe the percept for vacuum cleaner in vacuum world
 */
public interface Percept {
    /**
     * Checks if the area is dirty.
     * @return true if the area is dirty, false otherwise.
     */
    boolean isDirty();

    /**
     * Gets the current position from the sensor.
     * @return the current position.
     */
    Position getPosition();

    /**
     * Gets the number of clean cells in the world.
     * @return the number of clean cells in the world.
     */
    int getNumberOfCleanCells();
}
