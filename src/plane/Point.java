package plane;

import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Created by Viktor on 6/19/17.
 */

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            throw new IllegalArgumentException();

        if (!(other instanceof Point))
            throw new TypeMismatchException();

        if (this == other) {
            return true;
        }

        Point o = (Point) other;
        return x == o.getX()
                && y == o.getY();
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
