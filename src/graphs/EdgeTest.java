package graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Viktor on 6/22/17.
 * Tests class Edge.
 */
class EdgeTest {
    private final Edge e = new Edge(u, v, weight);
    private static final int u = 4, v = 16;
    private static final double weight = 3.0;

    @Test
    void either() {
        assertEquals(e.either(), u);
    }

    @Test
    void other() {
        assertEquals(e.other(e.either()), v);
    }

    @Test
    void getWeight() {
        assertEquals(e.getWeight(), weight);
    }

}