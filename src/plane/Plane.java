package plane;

import geometry.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Viktor on 6/19/17.
 */
public class Plane {
    private Boundaries boundaries;
    private List<Geometry> geometries = new LinkedList<>();
    private Point start;
    private Point end;

    public Plane(Boundaries boundaries, List<Geometry> geometries, Point start, Point end) {
        if (boundaries == null)
            throw new IllegalArgumentException("boundaries null");

        if (geometries == null)
            throw new IllegalArgumentException("geometries null");

        if (geometries.size() == 0)
            throw new IllegalArgumentException("geometries empty");

        if (start == null)
            throw new IllegalArgumentException("start point is null");

        if (end == null)
            throw new IllegalArgumentException("end point is null");

        this.boundaries = boundaries;
        this.geometries = geometries;
        this.start = start;
        this.end = end;
    }

    public void addGeometry(Geometry g) throws GeometryOutOfBoundsException {
        if (boundaries.fits(g)) {
            geometries.add(g);
        }
        else {
            throw new GeometryOutOfBoundsException();
        }
    }
}
