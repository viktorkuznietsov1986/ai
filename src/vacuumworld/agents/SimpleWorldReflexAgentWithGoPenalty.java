package vacuumworld.agents;

import vacuumworld.actions.*;
import vacuumworld.cleaner.VacuumCleaner;
import vacuumworld.misc.Direction;
import vacuumworld.misc.Percept;

/**
 * Created by Viktor on 6/8/17.
 */
public class SimpleWorldReflexAgentWithGoPenalty extends SimpleWorldReflexAgent {
    public SimpleWorldReflexAgentWithGoPenalty(VacuumCleaner cleaner) {
        super(cleaner);
    }

    @Override
    protected Action getAction(Percept p) {
        if (p == null) {
            throw new IllegalArgumentException("p cannot be null");
        }

        if (p.isDirty()) {
            return new SuckAction(cleaner);
        }

        Direction direction = chooseDirection(p.getPosition());

        if (cleaner.cango(direction)) {
            return new GoActionWithPenalty(cleaner, direction);
        }

        return new IdleAction(cleaner);
    }
}
