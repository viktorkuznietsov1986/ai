package graphs;

import java.util.*;

/**
 * Created by Viktor on 6/23/17.
 * Implementation of breadth-first search method.
 */
public class BFS implements Search {

    private double totalCost = 0.0;
    private Map<Integer, Node> nodes = new HashMap<>();
    private Node searchTree;

    public BFS(Graph g, int start, int end) {
        if (g == null)
            throw new IllegalArgumentException();

        if (start < 0 || start >= g.getV())
            throw new IllegalArgumentException();

        if (end < 0 || end >= g.getV())
            throw new IllegalArgumentException();


        Queue<Integer> q = new LinkedList<>();
        q.add(start);


        while (!q.isEmpty()) {
            int u = q.poll();

            if (!nodes.containsKey(u)) {
                Node n = new Node();
                n.action = () -> null;
                n.state = () -> u;
                n.parent = null;

                nodes.put(u, n);

            }

            if (u == end) {
                searchTree = nodes.get(u);
                break;
            }

            visit(g, q, u);
        }

        totalCost = searchTree.pathCost;
    }

    private void visit(Graph g, Queue<Integer> q, int u) {

        for (Iterator<Edge> it = g.getAdj(u); it.hasNext(); ) {
            Edge e = it.next();
            int v = e.other(u);
            if (!nodes.containsKey(v)) {
                q.add(v);
                Node n = new Node();
                n.action = () -> null;
                n.state = () -> v;
                n.parent = nodes.get(u);
                n.pathCost = n.parent.pathCost + e.getWeight();
                nodes.put(v, n);
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
