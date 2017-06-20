package plane;

/**
 * Created by Viktor on 6/19/17.
 */
public interface Boundaries {
    int getWidth();
    int getHeight();
    boolean fits(Geometry g);
    boolean fits(Point p);
}
