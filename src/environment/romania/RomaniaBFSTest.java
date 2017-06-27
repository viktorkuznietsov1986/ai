package environment.romania;

import graphs.BFS;
import graphs.Graph;
import graphs.Node;
import graphs.Search;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Viktor on 6/24/17.
 */
public class RomaniaBFSTest {
    public static void main(String[] args) {
        RomaniaBuilder builder = new RomaniaBuilder();
        Graph g = builder.getGraph();
        Search s = new BFS(g, builder.cities.get(Cities.Arad), builder.cities.get(Cities.Bucharest));

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
