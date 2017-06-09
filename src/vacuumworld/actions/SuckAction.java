package vacuumworld.actions;

import vacuumworld.cleaner.VacuumCleaner;

/**
 * Created by Viktor on 6/5/17.
 * Represents sucking action for the vacuum cleaner.
 */
public class SuckAction extends Action {

    /**
     * Ctor.
     * @param cleaner the vacuum cleaner.
     */
    public SuckAction(VacuumCleaner cleaner) {
        super(cleaner);
    }

    @Override
    public int perform() {
        cleaner.suck();
        return 1;
    }
}
