package vacuumworld;

/**
 * Created by evikuzn on 6/7/2017.
 */
public class SimpleWorldAgent extends Agent {
    public SimpleWorldAgent(VacuumCleanerModel cleaner) {
        super(cleaner);
    }

    @Override
    protected Direction chooseDirection(Position p) {
        if (p.getX() == 0)
            return Direction.RIGHT;

        return Direction.LEFT;
    }
}
