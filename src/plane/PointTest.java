package plane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Viktor on 6/20/17.
 */

public class PointTest {

    private static final int x = 5, y = 6;

    private Point pt;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        pt = new Point(x, y);
    }

    @Test
    void getX() {
        assertEquals(x, pt.getX());
    }

    @Test
    void getY() {
        assertEquals(y, pt.getY());
    }

    @Test
    void testEquals() {
        Point other = new Point(x,y);
        assertTrue(pt.equals(other));
    }
}
