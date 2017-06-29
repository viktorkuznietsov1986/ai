package graphs;

import java.util.*;

/**
 * Created by Viktor on 6/23/17.
 * Implementation of breadth-first search method.
 */
public class BFS implements Search {

    private double totalCost = 0.0;
    private Set<Node> nodes = new HashSet<>();
    private Node searchTree;

    public BFS(Problem problem, State start, State end) {
        if (problem == null)
            throw new IllegalArgumentException();

        if (start == null)
            throw new IllegalArgumentException();

        if (end == null)
            throw new IllegalArgumentException();


        Queue<Node> q = new LinkedList<>();
        Node n = new Node();
        n.parent = null;
        n.state = start;

        q.add(n);


        while (!q.isEmpty()) {
            n = q.poll();

            if (nodes.contains(n)) {
                continue;
            }

            nodes.add(n);

            if (n.getState().equals(end)) {
                searchTree = n;
                break;
            }

            visit(problem, q, n);
        }

        totalCost = searchTree.pathCost;
    }

    private void visit(Problem problem, Queue<Node> q, Node u) {

        List<Action> actions = problem.getActions(u.getState());

        for (Action a : actions) {
            Node childNode = u.getChildNode(problem, a);

            if (!nodes.contains(childNode)) {
                q.add(childNode);
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
        return totalCost;
    }

    /**
     * Gets the list of edges with the exact path.
     *
     * @return the list of edges with the exact path.
     */
    @Override
    public Node getSearchTree() {
        return searchTree;
    }
}
