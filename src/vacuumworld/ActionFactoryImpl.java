package vacuumworld;

/**
 * Created by evikuzn on 6/6/2017.
 */
public class ActionFactoryImpl implements ActionFactory {
    VacuumCleanerModel cleaner;

    ActionFactoryImpl(VacuumCleanerModel cleaner) {
        this.cleaner = cleaner;
    }

    @Override
    public Action newAction(Percept p) {
        if (p == null) {
            throw new IllegalArgumentException("p cannot be null");
        }

        if (p.isDirty()) {
            return new SuckAction(cleaner);
        }

        return new IdleAction(cleaner);
    }

}
