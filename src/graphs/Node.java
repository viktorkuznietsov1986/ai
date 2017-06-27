package graphs;

/**
 * Created by Viktor on 6/25/17.
 * Represents the node on the search path.
 */
public class Node {
    double pathCost;
    Node parent;
    State state;
    Action action;

    /**
     * Gets the pathCost.
     * @return gets the path cost.
     */
    public double getPathCost() {
        return pathCost;
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
     * Gets the action.
     * @return the action.
     */
    public Action getAction() {
        return action;
    }

}
