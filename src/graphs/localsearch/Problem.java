package graphs.localsearch;

import graphs.State;

public interface Problem extends graphs.Problem {
    /**
     * Gets the initial state for the Problem.
     * @return
     */
    State getInitialState();
}
