package graphs;

import java.util.List;

/**
 * Created by Viktor on 6/28/17.
 */
public interface Problem {

    List<Action> getActions(State state);
    State getResult(State parentState, Action action);
    double getStepCost(State parentState, Action action);
}
