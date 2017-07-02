package environment.romania;

import graphs.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Viktor on 7/1/17.
 */
public class GreedyBestFirstSearchTest {
    public static void main(String[] args) {

        System.out.println("GreedyBestFirstSearch test");

        Problem problem = new RomaniaProblem();

        try {
            Search s = new GreedyBestFirstSearch(problem, new State() {
                @Override
                public Object getState() {
                    return Cities.Arad;
                }
            }, new State() {
                @Override
                public Object getState() {
                    return Cities.Bucharest;
                }
            }, new BucharestHeuristics());

            Node n = s.getSearchTree();
            List<Cities> result = new LinkedList<>();

            while (n != null) {
                Cities state = ((Cities) n.getState().getState());
                result.add(0,  state);
                n = n.getParent();
            }

            for (Cities c : result) {
                System.out.println(c.toString());
            }

            System.out.println("Total cost: " + s.getSearchTree().getPathCost());
        }
        catch (FailureException e) {
            System.out.println("No path found.");
        }

    }
}
