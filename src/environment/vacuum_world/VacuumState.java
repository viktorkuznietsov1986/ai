package environment.vacuum_world;

import graphs.State;

import java.util.Arrays;

enum GridPosition {
    Left(0), Right(1);

    GridPosition(int val) {
        intValue = val;
    }
    public int getIntValue() {return intValue;}
    private int intValue;
}

public class VacuumState extends State {
    GridPosition position;
    boolean[] grid;
    static final int gridsize = 2;

    public VacuumState(boolean[] grd, GridPosition position) {
        this.position = position;

        grid = new boolean[gridsize];

        for (int i = 0; i < gridsize; ++i) {
            grid[i] = grd[i];
        }

    }

    public boolean isClean() {

        for (boolean cell : grid) {
            if (cell) {
                return false;
            }
        }

        return true;
    }

    public boolean isCurrentCellClean() {
        return !grid[position.getIntValue()];
    }

    @Override
    public Object getState() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        VacuumState other = (VacuumState)o;

        return Arrays.equals(grid, other.grid) && position == other.position;
    }
}
