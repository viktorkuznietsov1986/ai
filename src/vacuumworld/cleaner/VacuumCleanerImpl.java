package vacuumworld.cleaner;

import vacuumworld.exceptions.CantGoException;
import vacuumworld.misc.Direction;
import vacuumworld.misc.Position;
import vacuumworld.world.VacuumWorld;

/**
 * Created by Viktor on 6/5/17.
 */
public class VacuumCleanerImpl extends VacuumCleaner {


    public VacuumCleanerImpl(VacuumWorld world, Position position) {
        super(world, position);
    }

    @Override
    public void suck() {
        System.out.println("action: suck.");
        world.cleanSector(position);
    }

    @Override
    public void go(Direction direction) throws CantGoException {
        super.go(direction);
        System.out.println("action: go " + direction);
    }

    @Override
    public void idle() {
        System.out.println("action: idle.");
    }
}
