package geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Viktor on 6/22/17.
 */
class LineTest {

    private final Line line = new Line(1,1,1,3);

    @Test
    void getStart() {
        Point p = new Point(1, 1);
        assertTrue(p.equals(line.getStart()));
    }

    @Test
    void getEnd() {
        Point p = new Point(1, 3);
        assertTrue(p.equals(line.getEnd()));
    }

    @Test
    void getDistance() {
        assertEquals(line.getDistance(), 2.0);
    }

}