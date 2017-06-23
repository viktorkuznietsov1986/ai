package graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Viktor on 6/22/17.
 */
class GraphTest {

    private final static int v = 10;
    private Graph g;

    @BeforeEach
    void setUp() {
        g = new Graph(v);
        g.add(1, 2, 3);
        g.add(2, 3, 2);
    }

    @Test
    void add() {
        Graph g = new Graph(5);
        g.add(1, 2, 3.0);

        assertEquals(g.getE(), 1);

        Iterator<Edge> i = g.getAdj(1);

        assertTrue(i.hasNext());
        Edge e = i.next();
        assertFalse(i.hasNext());
        assertEquals(e.other(1), 2);
        assertEquals(e.other(2), 1);
        assertEquals(e.getWeight(), 3.0);

    }

    @Test
    void getV() {
        assertEquals(g.getV(), v);
    }

    @Test
    void getE() {
        assertEquals(g.getE(), 2);
    }

    @Test
    void getAdj() {
        Iterator<Edge> i = g.getAdj(2);

        assertTrue(i.hasNext());
        int count = 0;

        while (i.hasNext()) {
            Edge e = i.next();
            int u = e.other(2);
            assertTrue(u == 1 || u == 3);
            ++count;
        }

        assertEquals(count, 2);
    }


}