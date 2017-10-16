package graphs.nondeterministic;

import graphs.Action;
import graphs.Heuristics;
import graphs.State;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by Viktor on 10/16/17.
 * Represents the node on the search path with non-determinism.
 */
public class Node {
    double pathCost;
    Node parent;
    State state;
    //Heuristics heuristics;

    /*public Node(Heuristics heuristics) {
        this.heuristics = heuristics;
    }*/

    public Node(State state) {
        this.state = state;
    }

    /*public Node(Heuristics heuristics, State state) {
        this.heuristics = heuristics;
        this.state = state;
    }*/

    /**
     * Gets the pathCost.
     * @return gets the path cost.
     */
    public double getPathCost() {
        double h = 0.0;

        /*if (heuristics != null) {
            h = heuristics.getCost(this);
        }*/

        return pathCost + h;
    }

    /**
     * Gets the parent on the search path.
     * @return the parent on the search path.
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Gets the state.
     * @return the state.
     */
    public State getState() {
        return state;
    }

    /**
     * Gets the child nodes collection connected to the action.
     * @param problem
     * @param action
     * @return
     */
    public List<Node> getChildNodes(Problem problem, Action action) {
        return getChildNodes(problem, action, null);
    }

    /**
     * Gets the child nodes collection connected to the action.
     * @param problem
     * @param action
     * @param heuristics
     * @return
     */
    public List<Node> getChildNodes(Problem problem, Action action, Heuristics heuristics) {
        List<Node> result = new LinkedList<>();
        List<State> states = problem.getResult(state, action);

        for (State s : states) {
            result.add(new Node(s));
        }

        return result;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        graphs.Node o = (graphs.Node)other;

        return state.equals(o.getState()) &&
                pathCost == o.getPathCost();
    }

    public int hashCode() {
        int result = 17;
        result = 37*result + state.hashCode();

        long l = Double.doubleToLongBits(pathCost);
        int c = (int)(l ^ (l >>> 32));

        result = 37*result + c;

        return result;
    }

}

