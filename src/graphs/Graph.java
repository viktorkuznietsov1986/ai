package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Viktor on 6/13/17.
 * Represents unordered weighted graph data structure.
 */
public class Graph {
    protected int v;
    protected int e;
    protected List<Edge>[] adj;

    /**
     * Ctor.
     * @param v number of vertices.
     */
    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new List[v];

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * Add edge between 2 vertices.
     * @param i first vertex.
     * @param j second vertex.
     */
    public void add(int i, int j, int weight) {
        Edge edge = new Edge(i, j, weight);
        adj[i].add(edge);
        adj[j].add(edge);
        ++e;
    }

    /**
     * Get number of vertices.
     * @return number of vertices.
     */
    public int getV() {
        return v;
    }

    /**
     * Get number of edges.
     * @return number of edges.
     */
    public int getE() {
        return e;
    }

    /**
     * Get the adjacent list of the connected vertices.
     * @param i vertex id.
     * @return the adjacent list of the connected vertices.
     */
    public Iterator<Edge> getAdj(int i) {
        return adj[i].iterator();
    }
}
