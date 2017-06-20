package plane;

import java.util.List;

/**
 * Created by Viktor on 6/19/17.
 */
public class Plane {
    private Boundaries boundaries;
    private List<Geometry> geometries;
    private Point start;
    private Point end;

    public Plane(Boundaries boundaries) {
        this.boundaries = boundaries;
    }
}
