package graphs;

/**
 * Created by Viktor on 6/22/17.
 * Represents graph edge.
 */
public class Edge {
    private int u, v;
    private double weight;

    public Edge(int u, int v, double weight) {
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

    double getWeight() {
        return weight;
    }
}
