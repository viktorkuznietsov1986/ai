package vacuumworld;

/**
 * Created by evikuzn on 6/7/2017.
 */
public class SimpleWorldReflexAgent extends Agent {
    public SimpleWorldReflexAgent(VacuumCleanerModel cleaner) {
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
            return new GoAction(cleaner, direction);
        }

        return new IdleAction(cleaner);
    }

    @Override
    protected Direction chooseDirection(Position p) {
        if (p.getX() == 0)
            return Direction.RIGHT;

        return Direction.LEFT;
    }
}
