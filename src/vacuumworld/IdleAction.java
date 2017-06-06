package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 */
class IdleAction  extends Action {

    IdleAction(VacuumCleanerModel cleaner) {
        super(cleaner);
    }

    @Override
    void perform() {
        cleaner.idle();
    }
}
