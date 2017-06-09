package vacuumworld.agents;

import vacuumworld.misc.Direction;
import vacuumworld.misc.Percept;
import vacuumworld.misc.Position;
import vacuumworld.cleaner.VacuumCleaner;
import vacuumworld.actions.Action;

/**
 * Created by Viktor on 6/4/17.
 * Agent for vacuum cleaner in vacuum world.
 */
public abstract class Agent {

    protected VacuumCleaner cleaner;
    private int performance = 0;

    public Agent(VacuumCleaner cleaner) {
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
