package environment.romania;

import graphs.BFS;
import graphs.Graph;
import graphs.Search;

/**
 * Created by Viktor on 6/24/17.
 */
public class RomaniaBFSTest {
    public static void main(String[] args) {
        RomaniaBuilder builder = new RomaniaBuilder();
        Graph g = builder.getGraph();
        Search s = new BFS(g, builder.cities.get(Cities.Arad), builder.cities.get(Cities.Bucharest));

        for (Integer c : s.getPath()) {
            System.out.println(Cities.values()[c]);
        }

        System.out.println("Total cost: " + s.getCost());
    }
}
