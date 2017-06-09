package vacuumworld.actions;

import vacuumworld.cleaner.VacuumCleaner;

/**
 * Created by Viktor on 6/5/17.
 */
public class IdleAction  extends Action {

    public IdleAction(VacuumCleaner cleaner) {
        super(cleaner);
    }

    @Override
    public int perform() {
        cleaner.idle();
        return 0;
    }
}
