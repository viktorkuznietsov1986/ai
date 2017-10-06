package graphs.nondeterministic;

import graphs.Action;
import graphs.State;

import java.util.List;

public interface Problem {
    List<Action> getActions(State state);

    List<State> getResult(State parentState, Action action);

    double getStepCost(State parentState, Action action);
}
