package graphs;

import java.util.List;

/**
 * Created by Viktor on 6/25/17.
 */
public abstract class State {
    public abstract Object getState();
    public abstract boolean isGoal();
    public abstract List<State> getStatesAfterAction(Action a);
    public abstract List<Action> getAvailableActions();

    public boolean equals(Object other) {
        if (this == other)
            return true;

        State s = (State)other;

        return getState().equals(s.getState());
    }
}
