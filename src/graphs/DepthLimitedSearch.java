package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Viktor on 6/30/17.
 */
public class DepthLimitedSearch implements Search {

    private Node searchTree;
    private double totalCost = 0.0;
    private Set<Node> nodes = new HashSet<>();

    public DepthLimitedSearch(Problem problem, State start, State end, int limit) {

        Node n = new Node();
        n.state = start;

        searchTree = recursiveDLS(problem, n, end, limit);

        if (searchTree == n) {
            searchTree = null;
        }

        if (searchTree != null) {
            totalCost = searchTree.getPathCost();
        }
    }

    private Node recursiveDLS(Problem problem, Node n, State end, int limit) {
        if (n.getState().equals(end)) {
            searchTree = n;
            return n;
        }

        if (limit == 0) {
            return n;
        }

        List<Action> actions = problem.getActions(n.getState());

        boolean cutoff_occurred = false;

        for (Action a : actions) {
            Node u = n.getChildNode(problem, a);

            if (nodes.contains(u)) {
                continue;
            }
            else {
                nodes.add(u);
            }

            Node result = recursiveDLS(problem, u, end, limit-1);

            if (result == u) {
                cutoff_occurred = true;
            }

            if (result.getState().equals(end)) {
                searchTree = result;
                return result;
            }
        }

        if (cutoff_occurred) {
            return n;
        }

        return null;
    }


    /**
     * Gets the total cost of the path found.
     *
     * @return the total cost of the path found.
     */
    @Override
    public double getCost() {
        return totalCost;
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
