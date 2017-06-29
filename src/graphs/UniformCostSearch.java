package graphs;

import java.util.*;

/**
 * Created by Viktor on 6/27/17.
 * Represents Uniform Cost Search strategy.
 */
public class UniformCostSearch implements Search {

    private final double totalCost;
    private Node searchTree;
    private Set<Node> nodes = new HashSet<>();

    public UniformCostSearch(Problem problem, State start, State end) {
        if (problem == null)
            throw new IllegalArgumentException();

        if (start == null)
            throw new IllegalArgumentException();

        if (end == null)
            throw new IllegalArgumentException();

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> (int) (o1.pathCost - o2.pathCost));
        Node s = new Node();
        s.pathCost = 0.0;
        s.state = start;
        q.add(s);
        nodes.add(s);


        while (!q.isEmpty()) {
            Node n = q.poll();
            State state = n.getState();

            if (state.equals(end)) {
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

        /*
        for (Iterator<Edge> it = g.getAdj(u); it.hasNext(); ) {
            Edge e = it.next();
            int v = e.other(u);


            n.parent = nodes.get(u);
            n.pathCost = n.parent.pathCost + e.getWeight();

            if (!nodes.containsKey(v)
                    || nodes.get(v).getPathCost() > n.pathCost) {

                q.add(n);
            }

            nodes.put(v, n);

        }*/
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
