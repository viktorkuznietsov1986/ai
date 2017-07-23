package environment.eight_puzzle;

import graphs.Heuristics;
import graphs.Node;

public class ManhattanDistanceHeuristics implements Heuristics {
    @Override
    public double getCost(Node n) {
        Grid g = (Grid) n.getState().getState();

        return g.getManhattanDistance();
    }
}
