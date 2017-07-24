package environment.eight_puzzle;

import graphs.*;

import java.util.LinkedList;
import java.util.List;

public class AStarTest {
    public static void main(String[] args) {

        System.out.println("AStar search test.");

        Problem problem = new EightPuzzleProblem();

        try {
            Search s = new AStar(problem,
                    new GridState(new Grid(new int[][] {
                            {8,6,7},
                            {2,5,4},
                            {3,0,1}
                    }, 3))
                    ,
                    new GridState(new Grid(new int[][]{
                                    {1,2,3},
                                    {4,5,6},
                                    {7,8,0}
                            }, 3)),


            new ManhattanDistanceHeuristics());

            Node n = s.getSearchTree();
            List<Grid> result = new LinkedList<>();

            while (n != null) {
                Grid state = ((Grid) n.getState().getState());
                result.add(0,  state);
                n = n.getParent();
            }

            for (Grid c : result) {
                System.out.println(c);
            }

            System.out.println("Total cost: " + s.getCost());
        }
        catch (FailureException e) {
            System.out.println("No path found.");
        }

    }
}
