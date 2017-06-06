package vacuumworld;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Viktor on 6/5/17.
 */
public class VacuumCleanerImpl extends VacuumCleanerModel implements VacuumCleanerActor {


    @Override
    public void perform(Action action) {
        action.perform();
    }

    @Override
    void suck() {
        ++performance;
    }

    @Override
    boolean cango(Direction direction) {
        return false;
    }

    @Override
    void updatePosition(Direction direction) {

    }

    @Override
    void idle() {

    }
}
