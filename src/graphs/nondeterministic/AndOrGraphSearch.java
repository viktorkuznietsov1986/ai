package graphs.nondeterministic;

import graphs.Action;
import graphs.FailureException;
import graphs.State;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents the And-Or-Graph search algorithm for non-deterministic environments.
 */
public class AndOrGraphSearch extends Search {




    public AndOrGraphSearch(Problem problem, State start) throws FailureException {
        OrSearch(start, problem, new List<Node>());
    }

    private Map<Action, Node> OrSearch(State state, Problem problem, List<Node> path) throws FailureException {
        if (state.isGoal()) {
            return new HashMap<>();
        }

        if (path.contains(new Node(state)))
            throw new FailureException();


        for (Action a : problem.getActions(state)) {
            Map<State, Node> plan = AndSearch(problem.getResult(state, a), problem, path);
        }

    }

    private Map<State, Node> AndSearch(List<State> states, Problem problem, List<Node> path) throws FailureException {
        for (State s : states) {
            Map<Action, Node> plan = OrSearch(s, problem, path);
        }
    }
}
