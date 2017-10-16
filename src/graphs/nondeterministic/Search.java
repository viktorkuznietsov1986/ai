package graphs.nondeterministic;

/**
 * Represents the nondeterministic search. The difference with the deterministic is the type of search node.
 */
public class Search {
    protected Node searchTree;
    protected double cost;

    /**
     * Gets the total cost of the path found.
     * @return the total cost of the path found.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the search tree obtained from the tree / graph traversal.
     * @return the search tree obtained from the tree / graph traversal.
     */
    public Node getSearchTree() {
        return searchTree;
    }
}
