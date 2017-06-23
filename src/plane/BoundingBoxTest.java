package plane;

import geometry.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Viktor on 6/20/17.
 */
class BoundingBoxTest {

    private static final int x1 = 0, y1 = 0, x2 = 15, y2 = 10;

    private final BoundingBox b = new BoundingBox(x1, y1, x2, y2);


    @Test
    void getStart() {
        Point start = new Point(x1, y1);
        assertTrue(start.equals(b.getStart()));
    }

    @Test
    void getEnd() {
        Point end = new Point(x2, y2);
        assertTrue(end.equals(b.getEnd()));
    }

    @Test
    void createIncorrectX() {
        assertThrows(IllegalArgumentException.class, () -> new BoundingBox(x2, y1, x1, y2));
    }

    @Test
    void createIncorrectY() {
        assertThrows(IllegalArgumentException.class, () -> new BoundingBox(x1, y2, x2, y1));
    }

}