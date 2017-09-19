package graphs.localsearch;

import graphs.State;

/**
 * Represents the entity for local search algorithms.
 */
public interface LocalSearch {

    /**
     * Find the final state or throw exception.
     * @param problem the problem with initial state.
     * @return the final state which represents the solution for the problem.
     * @throws StateNotFoundException
     */
    State Search(Problem problem) throws StateNotFoundException;
}
