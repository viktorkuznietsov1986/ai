package environment.vacuum_world;

import graphs.Action;

import graphs.State;
import graphs.nondeterministic.Problem;

import java.util.LinkedList;
import java.util.List;

import static environment.vacuum_world.Actions.GoLeft;
import static environment.vacuum_world.Actions.GoRight;
import static environment.vacuum_world.Actions.Suck;

public class VacuumProblem implements Problem {


    @Override
    public List<Action> getActions(State state) {
        VacuumState s = (VacuumState) state;
        List<Action> result = new LinkedList<>();

        if (!s.isClean()) {
            if (s.isCurrentCellClean()) {
                switch (s.position) {
                    case Left:
                        result.add(() -> GoRight);
                        break;
                    case Right:
                        result.add(() -> GoLeft);
                        break;
                }
            }
            else {
                result.add(() -> Suck);
            }
        }

        return result;
    }

    @Override
    public List<State> getResult(State parentState, Action action) {
        VacuumState s = (VacuumState) parentState.getState();

        Actions a = (Actions) action.getAction();

        switch (a) {
            case Suck:

                break;
        }
    }

    @Override
    public double getStepCost(State parentState, Action action) {
        return 1.0;
    }
}
