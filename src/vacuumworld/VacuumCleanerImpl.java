package vacuumworld;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Viktor on 6/5/17.
 */
public class VacuumCleanerImpl extends VacuumCleanerModel {



    public VacuumCleanerImpl(VacuumWorld world) {

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
