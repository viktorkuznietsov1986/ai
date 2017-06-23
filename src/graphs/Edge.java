package graphs;

/**
 * Created by Viktor on 6/22/17.
 * Represents graph edge.
 */
public class Edge {
    private int u, v;
    private int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    int either() {
        return u;
    }

    int other(int v) {
        if (v == this.v)
            return this.u;

        return this.v;
    }

    int getWeight() {
        return weight;
    }
}
