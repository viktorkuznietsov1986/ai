package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 */
class GoAction extends Action {
    private Direction direction;

    public GoAction(VacuumCleanerModel cleaner, Direction direction) {
        super(cleaner);
        this.direction = direction;
    }

    @Override
    int perform() {
        try {
            cleaner.go(direction);
        } catch (CantGoException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
