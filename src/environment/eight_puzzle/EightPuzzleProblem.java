package environment.eight_puzzle;

import graphs.Action;
import graphs.IllegalStateException;
import graphs.Problem;
import graphs.State;

import java.util.List;

public class EightPuzzleProblem implements Problem {

    @Override
    public List<Action> getActions(State state) {
        Grid g = (Grid)state.getState();
        return g.getActions();

    }

    @Override
    public State getResult(State parentState, Action action) {
        Grid g = (Grid)parentState.getState();
        return new State() {
            @Override
            public Object getState() {
                try {
                    return g.go(action);
                } catch (IllegalStateException e) {
                    return null;
                }
            }
        };
    }

    @Override
    public double getStepCost(State parentState, Action action) {
        return  1.0;
    }
}
