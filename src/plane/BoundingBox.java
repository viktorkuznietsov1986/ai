package plane;

/**
 * Created by Viktor on 6/19/17.
 */
public class BoundingBox {

    private final int x1, y1, x2, y2;

    public BoundingBox(int x1, int y1, int x2, int y2) {
        if (x2 <= x1)
            throw new IllegalArgumentException("x2 <= x1");

        if (y2 <= y1)
            throw new IllegalArgumentException("y2 <= y1");

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Point getStart() {
        return new Point(x1, y1);
    }

    public Point getEnd() {
        return new Point(x2, y2);
    }
}
