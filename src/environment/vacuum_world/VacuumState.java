package environment.vacuum_world;

import graphs.Action;
import graphs.State;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

enum GridPosition {
    Left(0), Right(1);

    GridPosition(int val) {
        intValue = val;
    }
    public int getIntValue() {return intValue;}
    private int intValue;
}

public class VacuumState extends State {
    private GridPosition position;
    private boolean[] grid;
    private static final int gridsize = 2;

    public VacuumState(boolean[] grd, GridPosition position) {
        this.position = position;

        grid = new boolean[gridsize];

        for (int i = 0; i < gridsize; ++i) {
            grid[i] = grd[i];
        }

    }

    private boolean isClean() {

        for (boolean cell : grid) {
            if (cell) {
                return false;
            }
        }

        return true;
    }

    private boolean isCurrentCellClean() {
        return !grid[position.getIntValue()];
    }

    private List<State> getStatesAfterSuck() {
        List<State> result = new LinkedList<>();

        switch (position) {
            case Left:
                if (isCurrentCellClean()) { // if current cell clean, we can deposit some dirt there...
                    result.add(new VacuumState(new boolean[]{!grid[gridsize-2], grid[gridsize-1]}, position));
                }
                else {
                    // if current cell is not clean, we may clean the adjacent cell also.
                    result.add(new VacuumState(new boolean[]{false, false}, position));
                }

                // cleaning up our current cell.
                result.add(new VacuumState(new boolean[]{false, grid[gridsize-1]}, position));
                break;

            case Right:
                if (isCurrentCellClean()) { // if current cell clean, we can deposit some dirt there...
                    result.add(new VacuumState(new boolean[]{grid[gridsize-2], !grid[gridsize-1]}, position));
                }
                else {
                    // if current cell is not clean, we may clean the adjacent cell also.
                    result.add(new VacuumState(new boolean[]{false, false}, position));
                }

                // cleaning up our current cell.
                result.add(new VacuumState(new boolean[]{grid[gridsize-2], false}, position));
                break;
        }

        return result;
    }

    private List<State> getStatesAfterGoLeft() {
        List<State> result = new LinkedList<>();

        switch (position) {
            case Left:

                break;

            case Right:
                result.add(new VacuumState(new boolean[]{grid[gridsize-1], grid[gridsize-1]}, GridPosition.Left));
                break;
        }

        return result;
    }

    private List<State> getStatesAfterGoRight() {
        List<State> result = new LinkedList<>();

        switch (position) {
            case Left:
                result.add(new VacuumState(new boolean[]{grid[gridsize-1], grid[gridsize-1]}, GridPosition.Right));
                break;

            case Right:

                break;
        }

        return result;
    }

    @Override
    public Object getState() {
        return this;
    }

    @Override
    public boolean isGoal() {
        return isClean();
    }

    @Override
    public List<State> getStatesAfterAction(Action a) {
        Actions action = (Actions) a.getAction();

        List<State> result = new LinkedList<>();

        switch (action) {
            case Suck:
                result.addAll(getStatesAfterSuck());
                break;

            case GoLeft:
                result.addAll(getStatesAfterGoLeft());
                break;

            case GoRight:
                result.addAll(getStatesAfterGoRight());
                break;

        }

        return result;
    }

    @Override
    public List<Action> getAvailableActions() {
        List<Action> result = new LinkedList<>();

        switch (position) {
            case Left:
                result.add(() -> Actions.GoRight);
                break;

            case Right:
                result.add(() -> Actions.GoLeft);
                break;
        }

        if (!isCurrentCellClean()) {
            result.add(() -> Actions.Suck);
        }

        return result;
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
