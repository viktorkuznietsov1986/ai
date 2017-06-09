package vacuumworld.agents;

import vacuumworld.cleaner.VacuumCleaner;
import vacuumworld.misc.Direction;
import vacuumworld.misc.Percept;
import vacuumworld.misc.Position;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Viktor on 6/8/17.
 */
public class SimpleWorldStateReflexAgent extends SimpleWorldReflexAgentWithGoPenalty {

    private Set<Position> visited = new HashSet<>();

    public SimpleWorldStateReflexAgent(VacuumCleaner cleaner) {
        super(cleaner);
        visited.add(cleaner.getStartPosition());
    }

    @Override
    protected Direction chooseDirection(Position p) {
        if (visited.contains(p)) {
            return Direction.NONE;
        }

        if (p.getX() == 0)
            return Direction.RIGHT;

        return Direction.LEFT;
    }

    @Override
    public void perform(Percept p) {
        super.perform(p);

        if (!visited.contains(p.getPosition())) {
            visited.add(p.getPosition());
        }
    }
}
