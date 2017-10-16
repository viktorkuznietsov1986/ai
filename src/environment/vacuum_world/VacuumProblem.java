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
        return state.getAvailableActions();
    }

    @Override
    public List<State> getResult(State parentState, Action action) {
        if (parentState.isGoal()) {
            return new LinkedList<>();
        }

        return parentState.getStatesAfterAction(action);
    }

    @Override
    public double getStepCost(State parentState, Action action) {
        return 1.0;
    }
}
