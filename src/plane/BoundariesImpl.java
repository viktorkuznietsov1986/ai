package plane;

/**
 * Created by Viktor on 6/19/17.
 */
public class BoundariesImpl implements Boundaries {

    private final int startX, startY;
    private final int endX, endY;

    public BoundariesImpl(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public int getWidth() {
        return endX - startX;
    }

    @Override
    public int getHeight() {
        return endY - startY;
    }

    @Override
    public boolean fits(Geometry g) {

        for (Point p : g.points) {
            if (!fits(p)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean fits(Point p) {
        return startX <= p.getX() &&
                startY <= p.getY() &&
                endX >= p.getX() &&
                endY >= p.getY();
    }
}
