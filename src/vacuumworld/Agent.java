package vacuumworld;

/**
 * Created by Viktor on 6/4/17.
 * Agent for vacuum cleaner in vacuum world.
 */
public abstract class Agent {

    protected VacuumCleanerModel cleaner;
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
        performance += p.getNumberOfCleanCells() + action.perform();
    }

    public int getPerformance() {
        return performance;
    }

    protected abstract Action getAction(Percept p);

    protected abstract Direction chooseDirection(Position p);
}
