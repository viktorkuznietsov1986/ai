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

    public BoundingBox getBoundingBox() throws EmptyGeometryException {
        if (points.size() == 0)
            throw new EmptyGeometryException();

        Iterator<Point> pts = points.iterator();


    }

    public int getNumberOfVertices() {
        return points.size();
    }
}
