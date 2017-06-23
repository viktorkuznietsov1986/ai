package geometry;

/**
 * Created by Viktor on 6/22/17.
 * Represents line feature.
 */
public class Line {
    private final Point start, end;
    private final double distance;

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);

        this.distance = Math.sqrt(Math.pow(x2-x1, 2.0) + Math.pow(y2-y1, 2.0));
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double getDistance() {
        return distance;
    }
}
