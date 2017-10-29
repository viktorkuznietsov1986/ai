package graphs.nondeterministic;

import graphs.Action;
import graphs.FailureException;
import graphs.State;

import java.util.*;

/**
 * Represents the And-Or-Graph search algorithm for non-deterministic environments.
 */
public class AndOrGraphSearch extends Search {

    private Node _plan;

    /**
     * Gets the conditional plan to reach every state from start state.
     * @return the conditional plan to reach every state from start state.
     */
    public Node getPlan() {
        return _plan;
    }


    public AndOrGraphSearch(Problem problem, State start) throws FailureException {
        Map<State, Node> result = OrSearch(start, problem, new LinkedList<>());

        if (!result.isEmpty()) {

        }
    }

    private Map<State, Node> OrSearch(State state, Problem problem, List<Node> path) throws FailureException {
        if (state.isGoal()) {
            return new HashMap<>();
        }

        if (path.contains(new Node(state)))
            throw new FailureException();


        for (Action a : problem.getActions(state)) {
            try {
                Map<State, Node> plan = AndSearch(problem.getResult(state, a), problem, path);
                return plan;
            }
            catch (FailureException e) {
                // todo: do nothing as there should be at least one path; if no correct path, it'll throw a new FailureException.
            }

        }

        throw new FailureException();

    }

    private Map<State, Node> AndSearch(List<State> states, Problem problem, List<Node> path) throws FailureException {
        Map<State, Node> result = new HashMap<>();

        for (State s : states) {
            try {
                Map<State, Node> plan = OrSearch(s, problem, path);

                result.putAll(plan);
            }
            catch (FailureException e) {
                throw e;
            }

        }

        return result;
    }
}
