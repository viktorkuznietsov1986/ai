package graphs;

/**
 * Created by Viktor on 6/23/17.
 * Base interface for each tree / graph searching algorithm.
 */
public interface Search {
    /**
     * Gets the total cost of the path found.
     * @return the total cost of the path found.
     */
    double getCost();

    /**
     * Gets the search tree obtained from the tree / graph traversal.
     * @return the search tree obtained from the tree / graph traversal.
     */
    Node getSearchTree();
}
