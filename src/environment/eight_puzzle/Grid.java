package environment.eight_puzzle;

import graphs.Action;
import graphs.IllegalStateException;

import java.util.*;

public class Grid {
    private final static int EMPTY = 0;

    private final int[][] _state;

    private int _emptyX;
    private int _emptyY;
    private final int _gridSize;

    public Grid(int[][] initialState, int size) {
        _state = new int[size][size];
        _gridSize = size;

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                int value = initialState[i][j];
                _state[i][j] = value;

                if (value == EMPTY) {
                    _emptyX = j;
                    _emptyY = i;
                }
            }
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < _gridSize; ++i) {
            for (int j = 0; j < _gridSize; ++j) {
                s += _state[i][j] + " ";
            }
            s += '\n';
        }

        return s;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Grid g = (Grid) o;

        if (_gridSize != g._gridSize)
            return false;

        for (int i = 0; i < _gridSize; ++i) {
            for (int j = 0; j < _gridSize; ++j) {
                if (_state[i][j] != g._state[i][j])
                    return false;
            }
        }

        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(_state);
    }

    public List<Action> getActions() {
        List<Action> actions = new LinkedList<>();

        // try to go left
        if (canGoLeft()) {
            actions.add(() -> GridActions.LEFT);
        }

        // try to go right
        if (canGoRight()) {
            actions.add(() -> GridActions.RIGHT);
        }

        // try to go up
        if (canGoUp()) {
            actions.add(() -> GridActions.UP);
        }

        // try to go down
        if (canGoDown()) {
            actions.add(() -> GridActions.DOWN);
        }

        return actions;
    }

    private boolean canGoLeft() {
        return _emptyX > 0;
    }

    private boolean canGoRight() {
        return _emptyX < _gridSize - 1;
    }

    private boolean canGoUp() {
        return _emptyY > 0;
    }

    private boolean canGoDown() {
        return _emptyY < _gridSize - 1;
    }

    public Grid go(Action action) throws IllegalStateException {
        GridActions direction = (GridActions) action.getAction();

        Grid g = new Grid(_state, _gridSize);
        int v;

        switch (direction) {
            case UP:
                if (canGoUp()) {
                    v = g._state[--g._emptyY][g._emptyX];
                }
                else {
                    throw new IllegalStateException();
                }
                break;

            case DOWN:
                if (canGoDown()) {
                    v = g._state[++g._emptyY][g._emptyX];
                }
                else {
                    throw new IllegalStateException();
                }
                break;

            case LEFT:
                if (canGoLeft()) {
                    v = g._state[g._emptyY][--g._emptyX];
                }
                else {
                    throw new IllegalStateException();
                }
                break;

            case RIGHT:
                if (canGoRight()) {
                    v = g._state[g._emptyY][++g._emptyX];
                }
                else {
                    throw new IllegalStateException();
                }
                break;

            default:
                throw new IllegalStateException();
        }

        g._state[g._emptyY][g._emptyX] = EMPTY;
        g._state[_emptyY][_emptyX] = v;

        /*if (sameBoardPosition(g)) {
            return this;
        }*/

        return g;
    }

    private boolean sameBoardPosition(Grid g) {
        if (this == g) {
            return true;
        }

        for (int i = 0; i < _gridSize; ++i) {
            int rowSumOrig = 0;
            int rowSumG = 0;

            for (int j = 0; j < _gridSize; ++j) {
                rowSumOrig += _state[i][j];
                rowSumG += g._state[i][j];
            }

            if (rowSumG != rowSumOrig)
                return false;
        }

        return true;
    }

    public double getMisplacedTiles() {
        int cnt = 0;

        for (int i = 0; i < _gridSize; ++i) {
            for (int j = 0; j < _gridSize; ++j) {
                if (i == _gridSize-1 && j == _gridSize-1)
                    continue;

                if (_state[i][j] != i*_gridSize + j)
                    ++cnt;
            }
        }

        return (double)cnt;
    }

    public double getManhattanDistance() {
        int cnt = 0;

        for (int i = 0; i < _gridSize; ++i) {
            for (int j = 0; j < _gridSize; ++j) {
                int v = _state[i][j];

                if (v == 0)
                    continue;

                int vpos_i = (v-1)/_gridSize;
                int vpos_j = (v-1)%_gridSize;

                cnt += Math.abs(i-vpos_i) + Math.abs(j-vpos_j);
            }
        }

        return (double) cnt;
    }

    public static void main(String[] args) {
        Grid g = new Grid(new int[][] {
                {7,2,4},
                {5,0,6},
                {8,3,1}
        }, 3);

        System.out.println(g);

        try {
            System.out.println(g.go(()->GridActions.UP));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(g.go(()->GridActions.LEFT
            ));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(g.go(()->GridActions.RIGHT));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(g.go(()->GridActions.DOWN));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        System.out.println(g.getMisplacedTiles());

        g = new Grid(new int[][] {
                {1,0,2},
                {3,4,5},
                {6,7,8}
        }, 3);

        Grid g1 = new Grid(new int[][] {
                {1,0,2},
                {3,4,5},
                {6,7,8}
        }, 3);

        Set<Grid> s = new HashSet<>();
        s.add(g);

        System.out.println(s.contains(g1));

        System.out.println(g.getMisplacedTiles());
    }
}
