package graphs;

/**
 * Created by Viktor on 6/30/17.
 */
public class IterativeDeepingSearch implements Search {

    private Node searchTree;
    private double cost;

    public IterativeDeepingSearch(Problem problem, State start, State end) throws FailureException {
        for (int depth = 0; true; ++depth) {
            try {
                Search s = new DepthLimitedSearch(problem, start, end, depth);
                searchTree = s.getSearchTree();
                cost = searchTree.pathCost;
                return;
            } catch (CutoffException e) {
                continue;
            } catch (FailureException e) {
                throw e;
            }
        }
    }

    /**
     * Gets the total cost of the path found.
     *
     * @return the total cost of the path found.
     */
    @Override
    public double getCost() {
        return cost;
    }

    /**
     * Gets the search tree obtained from the tree / graph traversal.
     *
     * @return the search tree obtained from the tree / graph traversal.
     */
    @Override
    public Node getSearchTree() {
        return searchTree;
    }
}
