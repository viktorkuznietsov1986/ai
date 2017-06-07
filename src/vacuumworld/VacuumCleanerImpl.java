package vacuumworld;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Viktor on 6/5/17.
 */
public class VacuumCleanerImpl extends VacuumCleanerModel {


    public VacuumCleanerImpl(VacuumWorld world, Position position) {
        super(world, position);
    }

    @Override
    void suck() {
        System.out.println("action: suck.");
        world.cleanSector(position);
    }

    @Override
    void go(Direction direction) throws CantGoException {
        super.go(direction);
        System.out.println("action: go " + direction);
    }

    @Override
    void idle() {
        System.out.println("action: idle.");
    }
}
