package graphs;

import environment.romania.Cities;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Viktor on 6/23/17.
 * Implementation of breadth-first search method.
 */
public class BFS implements Search {

    private double totalCost = 0.0;
    private List<Integer> path = new LinkedList<>();
    private boolean[] visited;
    private Edge[] parents;

    public BFS(Graph g, int start, int end) {
        if (g == null)
            throw new IllegalArgumentException();

        if (start < 0 || start >= g.getV())
            throw new IllegalArgumentException();

        if (end < 0 || end >= g.getV())
            throw new IllegalArgumentException();

        visited = new boolean[g.getV()];

        parents = new Edge[g.getV()];


        Queue<Integer> q = new LinkedList<>();
        q.add(start);


        while (!q.isEmpty()) {
            int u = q.poll();

            if (!visited[u]) {
                visit(g, q, u);
            }
        }

        findPath(start, end);
    }

    private void visit(Graph g, Queue<Integer> q, int u) {
        visited[u] = true;

        for (Iterator<Edge> it = g.getAdj(u); it.hasNext(); ) {
            Edge e = it.next();
            int v = e.other(u);
            if (!visited[v]) {
                q.add(v);
                parents[v] = e;
            }
        }
    }

    private void findPath(int start, int end) {
        if ((start == end) || (end == -1)) {
            path.add(0, start);
        }
        else {
            Edge e = parents[end];

            if (e != null) {
                totalCost += e.getWeight();
                path.add(0, end);
                findPath(start, e.other(end));
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
    public List<Integer> getPath() {
        return path;
    }
}
