package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 */
class SuckAction extends Action {

    SuckAction(VacuumCleanerModel cleaner) {
        super(cleaner);
    }

    @Override
    public void perform() {
        cleaner.suck();
    }
}
