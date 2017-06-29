package graphs;

/**
 * Created by Viktor on 6/25/17.
 */
public abstract class State {
    public abstract Object getState();

    public boolean equals(Object other) {
        if (this == other)
            return true;

        State s = (State)other;

        return getState().equals(s.getState());
    }
}
