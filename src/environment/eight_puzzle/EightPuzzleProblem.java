package environment.eight_puzzle;

import graphs.Action;
import graphs.IllegalStateException;
import graphs.State;
import graphs.localsearch.Problem;

import java.util.List;

public class EightPuzzleProblem implements Problem {

    private State initialState;

    public EightPuzzleProblem() {

    }

    public EightPuzzleProblem(State initialState) {
        this.initialState = initialState;
    }

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

    /**
     * Gets the initial state for the Problem.
     *
     * @return
     */
    @Override
    public State getInitialState() {
        return initialState;
    }
}
