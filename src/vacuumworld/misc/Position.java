package vacuumworld.misc;

/**
 * Created by Viktor on 6/4/17.
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
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
    public boolean equals(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        Position p = (Position) o;

        return this.x == p.x && this.y == p.y;
    }

    @Override
    public int hashCode() {
        int code = 17;
        code = 31*code + x;
        code = 31*code + y;
        return code;
    }
}
