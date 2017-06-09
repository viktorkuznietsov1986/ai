package vacuumworld.actions;

import vacuumworld.misc.Direction;
import vacuumworld.cleaner.VacuumCleaner;

/**
 * Created by Viktor on 6/8/17.
 * Represents the class for Go action with penalty. Each step brings the penalty of 1 point.
 */
public class GoActionWithPenalty extends GoAction {

    /**
     * Ctor.
     * @param cleaner Vacuum cleaner.
     * @param direction Direction to go.
     */
    public GoActionWithPenalty(VacuumCleaner cleaner, Direction direction) {
        super(cleaner, direction);
    }

    /**
     * Any move brings penalty of 1 point.
     * @return the overall performance for a step.
     */
    @Override
    public int perform() {
        return super.perform() - 1;
    }
}
