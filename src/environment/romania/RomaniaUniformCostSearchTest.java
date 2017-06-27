package environment.romania;

import graphs.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Viktor on 6/27/17.
 */
public class RomaniaUniformCostSearchTest {
    public static void main(String[] args) {
        RomaniaBuilder builder = new RomaniaBuilder();
        Graph g = builder.getGraph();
        Search s = new UniformCostSearch(g, builder.cities.get(Cities.Arad), builder.cities.get(Cities.Bucharest));

        Node n = s.getSearchTree();
        List<Integer> result = new LinkedList<>();

        while (n != null) {
            int state = ((Integer) n.getState().getState()).intValue();
            result.add(0,  state);
            n = n.getParent();
        }

        for (Integer c : result) {
            System.out.println(Cities.values()[c]);
        }

        System.out.println("Total cost: " + s.getSearchTree().getPathCost());
    }
}
