package vacuumworld;

/**
 * Created by Viktor on 6/4/17.
 * Agent for vacuum cleaner in vacuum world.
 */
public class Agent {

    private VacuumCleanerModel cleaner;
    private int performance = 0;

    public Agent(VacuumCleanerModel cleaner) {
        this.cleaner = cleaner;
    }

    /**
     * Act according to the percept.
     * @param p percept.
     */
    public void perform(Percept p) {
        Action action = getAction(p);
        action.perform();
    }

    public int getPerformance() {
        return performance;
    }

    protected Action getAction(Percept p) {
        if (p == null) {
            throw new IllegalArgumentException("p cannot be null");
        }

        if (p.isDirty()) {
            return new SuckAction(cleaner);
        }

        Direction direction = chooseDirection(p.getPosition());

        if (cleaner.cango(direction)) {
            return new GoAction(cleaner, direction);
        }

        return new IdleAction(cleaner);
    }

    protected Direction chooseDirection(Position p) {
        return Direction.DOWN;
    }
}
