package graphs;

/**
 * Created by Viktor on 6/23/17.
 * Base interface for each tree / graph searching algorithm.
 */
public abstract class Search {

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
