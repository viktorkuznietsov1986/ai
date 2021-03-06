package environment.romania;

import graphs.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Viktor on 6/30/17.
 */
public class RomaniaDepthLimitesSearchTest {
    public static void main(String[] args) {

        System.out.println("Depth Limited Search test.");

        Problem problem = new RomaniaProblem();

        int depth = 3;

        try {
            Search s = new DepthLimitedSearch(problem, new State() {
                @Override
                public Object getState() {
                    return Cities.Arad;
                }
            }, new State() {
                @Override
                public Object getState() {
                    return Cities.Bucharest;
                }
            }, depth);

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

            System.out.println("Total cost: " + s.getCost());
        }
        catch (CutoffException e) {
            System.out.println("Cutoff happened. Nothing has been found at depth " + depth);
        }
        catch (FailureException e) {
            System.out.println("Search failure. No path exists.");
        }

    }
}
