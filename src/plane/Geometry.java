package plane;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Viktor on 6/19/17.
 */
public abstract class Geometry {
    protected List<Point> points;

    public Geometry() {
        points = new LinkedList<>();
    }

    public BoundingBox getBoundingBox() throws InvalidGeometryException {
        if (points.size() <= 1)
            throw new InvalidGeometryException();

        Iterator<Point> pts = points.iterator();

        Point pt = pts.next();
        int minx = pt.getX(), maxx = pt.getX(), miny = pt.getY(), maxy = pt.getY();

        while (pts.hasNext()) {
            pt = pts.next();

            if (minx > pt.getX()) {
                minx = pt.getX();
            } else if (maxx < pt.getX()) {
                maxx = pt.getX();
            }

            if (miny > pt.getY()) {
                miny = pt.getY();
            }
            else if (maxy < pt.getY()) {
                maxy = pt.getY();
            }
        }

        return new BoundingBox(minx, miny, maxx, maxy);

    }

    public List<Point> getPoints() {
        return points;
    }

    public int getNumberOfVertices() {
        return points.size();
    }
}
