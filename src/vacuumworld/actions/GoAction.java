package vacuumworld.actions;

import vacuumworld.exceptions.CantGoException;
import vacuumworld.misc.Direction;
import vacuumworld.cleaner.VacuumCleaner;

/**
 * Created by Viktor on 6/5/17.
 * Represents Go action with no penalty.
 */
public class GoAction extends Action {
    private Direction direction;

    /**
     * Ctor.
     * @param cleaner Vacuum cleaner.
     * @param direction Direction to go.
     */
    public GoAction(VacuumCleaner cleaner, Direction direction) {
        super(cleaner);
        this.direction = direction;
    }

    /**
     * Does the actual work and returns the performance value for the specified step.
     * @return zero performance (no penalty).
     */
    @Override
    public int perform() {
        try {
            cleaner.go(direction);
        } catch (CantGoException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
