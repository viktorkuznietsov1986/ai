package graphs;

/**
 * Created by Viktor on 6/25/17.
 * Represents the node on the search path.
 */
public class Node {
    double pathCost;
    Node parent;
    State state;
    Heuristics heuristics;

    public Node() {

    }

    public Node(Heuristics heuristics) {
        this.heuristics = heuristics;
    }

    public Node(State state) {
        this.state = state;
    }

    public Node(Heuristics heuristics, State state) {
        this.heuristics = heuristics;
        this.state = state;
    }

    /**
     * Gets the pathCost.
     * @return gets the path cost.
     */
    public double getPathCost() {
        double h = 0.0;

        if (heuristics != null) {
            h = heuristics.getCost(this);
        }

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
     * Gets the child node connected to the action.
     * @param problem
     * @param action
     * @return
     */
    public Node getChildNode(Problem problem, Action action) {
        return getChildNode(problem, action, null);
    }

    /**
     * Gets the child node connected to the action.
     * @param problem
     * @param action
     * @param heuristics
     * @return
     */
    public Node getChildNode(Problem problem, Action action, Heuristics heuristics) {
        Node node = new Node();
        node.state = problem.getResult(state, action);
        node.parent = this;
        node.pathCost = pathCost + problem.getStepCost(state, action);
        node.heuristics = heuristics;
        return node;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        Node o = (Node)other;

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
