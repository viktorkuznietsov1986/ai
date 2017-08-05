package graphs.localsearch;

import graphs.Action;
import graphs.Heuristics;
import graphs.Node;
import graphs.State;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Implements basic HillClimbing search.
 */
public class HillClimbing implements LocalSearch {

    private Heuristics _heuristics;

    public HillClimbing(Heuristics heuristics) {
        _heuristics = heuristics;
    }

    /**
     * Find the final state or throw exception.
     *
     * @param problem the problem with initial state.
     * @return the final state which represents the solution for the problem.
     * @throws StateNotFoundException
     */
    @Override
    public State Search(Problem problem) throws StateNotFoundException {
        Node current = new Node(_heuristics, problem.getInitialState());

        while (true) {
            Node neighbour = getHighestValuedSuccessor(problem, current);

            if (neighbour.getPathCost() > current.getPathCost()) {
                return current.getState();
            }

            current = neighbour;
        }

    }

    /**
     * To be re-implemented with regards to different possible options for implementation of HillClimbing approach.
     * @param problem the instance of problem.
     * @param current the current Node to be processed.
     * @return the highest valued successor for the current node.
     */
    protected Node getHighestValuedSuccessor(Problem problem, Node current) {

        List<Action> actions = problem.getActions(current.getState());
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> (int)(o1.getPathCost()-o2.getPathCost()));

        for (Action a : actions) {
            q.add(current.getChildNode(problem, a, _heuristics));
        }

        return q.poll();
    }
}
