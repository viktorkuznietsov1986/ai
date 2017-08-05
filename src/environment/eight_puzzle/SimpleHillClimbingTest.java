package environment.eight_puzzle;

import graphs.*;
import graphs.localsearch.HillClimbing;
import graphs.localsearch.LocalSearch;
import graphs.localsearch.Problem;
import graphs.localsearch.StateNotFoundException;

public class SimpleHillClimbingTest {
    public static void main(String[] args) {

        System.out.println("Simple Hill Climbing test.");

        State initialState = new GridState(new Grid(new int[][] {
                {1,2,3},
                {4,5,6},
                {7,0,8}
        }, 3));

        Problem problem = new EightPuzzleProblem(initialState);

        try {
            LocalSearch s = new HillClimbing(new ManhattanDistanceHeuristics());
            State finalState = s.Search(problem);

            Grid state = (Grid)finalState.getState();
            System.out.println(state);

            //System.out.println("Total cost: " + finalState. .getCost());
        }
        catch (StateNotFoundException e) {
            System.out.println("The final state cannot be reached.");
        }
    }
}
