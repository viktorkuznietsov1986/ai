package graphs;

import java.util.*;

/**
 * Created by Viktor on 6/27/17.
 * Represents Uniform Cost Search strategy.
 */
public class UniformCostSearch implements Search {

    private final double totalCost;
    private Node searchTree;
    private Map<Integer, Node> nodes = new HashMap<>();

    public UniformCostSearch(Graph g, int start, int end) {
        if (g == null)
            throw new IllegalArgumentException();

        if (start < 0 || start >= g.getV())
            throw new IllegalArgumentException();

        if (end < 0 || end >= g.getV())
            throw new IllegalArgumentException();

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> (int) (o1.pathCost - o2.pathCost));
        Node s = new Node();
        s.pathCost = 0.0;
        s.state = () -> start;
        q.add(s);
        nodes.put(start, s);


        while (!q.isEmpty()) {
            Node n = q.poll();
            int u = (int)n.getState().getState();

            if (u == end) {
                searchTree = nodes.get(u);
                break;
            }

            visit(g, q, u);
        }

        totalCost = searchTree.pathCost;
    }

    private void visit(Graph g, Queue<Node> q, int u) {

        for (Iterator<Edge> it = g.getAdj(u); it.hasNext(); ) {
            Edge e = it.next();
            int v = e.other(u);

            Node n = new Node();
            n.action = () -> null;
            n.state = () -> v;
            n.parent = nodes.get(u);
            n.pathCost = n.parent.pathCost + e.getWeight();

            if (!nodes.containsKey(v)
                    || nodes.get(v).getPathCost() > n.pathCost) {

                q.add(n);
            }

            nodes.put(v, n);

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
     * Gets the search tree obtained from the tree / graph traversal.
     *
     * @return the search tree obtained from the tree / graph traversal.
     */
    @Override
    public Node getSearchTree() {
        return searchTree;
    }
}
