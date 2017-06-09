package vacuumworld.actions;

import vacuumworld.cleaner.VacuumCleaner;

/**
 * Created by Viktor on 6/4/17.
 * Represents the action performed under VacuumCleaner.
 */
public abstract class Action {

    VacuumCleaner cleaner;

    public Action(VacuumCleaner cleaner) {
        if (cleaner == null) {
            throw new IllegalArgumentException("cleaner cannot be null");
        }

        this.cleaner = cleaner;
    }

    /**
     * Does the actual work and returns the performance value for the specified step.
     * @return
     */
    public abstract int perform();
}
