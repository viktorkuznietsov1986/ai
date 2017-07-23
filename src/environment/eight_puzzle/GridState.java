package environment.eight_puzzle;

import graphs.State;

public class GridState extends State {

    private Grid _g;

    public GridState(Grid g) {
        _g = g;
    }

    @Override
    public Object getState() {
        return _g;
    }

    @Override
    public int hashCode(){
        return _g.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        GridState s = (GridState) o;
        return _g.equals(s.getState());
    }
}
