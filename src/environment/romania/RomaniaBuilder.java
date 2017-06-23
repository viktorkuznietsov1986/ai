package environment.romania;

import graphs.Graph;
import graphs.GraphBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Viktor on 6/22/17.
 */
public class RomaniaBuilder implements GraphBuilder {

    Map<Cities, Integer> cities = new HashMap<>();

    public RomaniaBuilder() {
        int i = 0;

        for (Cities c : Cities.values()) {
            cities.put(c, i++);
        }
    }


    /**
     * Gets the graph.
     *
     * @return
     */
    @Override
    public Graph getGraph() {
        Graph g = new Graph(Cities.values().length);
        g.add(cities.get(Cities.Oradea), cities.get(Cities.Zerind), 71.0);
        g.add(cities.get(Cities.Zerind), cities.get(Cities.Arad), 75.0);
        g.add(cities.get(Cities.Oradea), cities.get(Cities.Sibiu), 151.0);
        g.add(cities.get(Cities.Arad), cities.get(Cities.Sibiu), 140.0);
        g.add(cities.get(Cities.Arad), cities.get(Cities.Timisoara), 118.0);
        g.add(cities.get(Cities.Timisoara), cities.get(Cities.Lugoj), 111.0);
        g.add(cities.get(Cities.Lugoj), cities.get(Cities.Mehadia), 70.0);
        g.add(cities.get(Cities.Mehadia), cities.get(Cities.Drobeta), 75.0);
        g.add(cities.get(Cities.Drobeta), cities.get(Cities.Craiova), 120.0);
        g.add(cities.get(Cities.Craiova), cities.get(Cities.RimnicuVilcea), 146.0);
        g.add(cities.get(Cities.Craiova), cities.get(Cities.Pitesti), 138.0);
        g.add(cities.get(Cities.Sibiu), cities.get(Cities.RimnicuVilcea), 80.0);
        g.add(cities.get(Cities.RimnicuVilcea), cities.get(Cities.Pitesti), 97.0);
        g.add(cities.get(Cities.Pitesti), cities.get(Cities.Bucharest), 101.0);
        g.add(cities.get(Cities.Sibiu), cities.get(Cities.Fagaras), 99.0);
        g.add(cities.get(Cities.Fagaras), cities.get(Cities.Bucharest), 211.0);
        g.add(cities.get(Cities.Bucharest), cities.get(Cities.Giurgiu), 90.0);
        g.add(cities.get(Cities.Bucharest), cities.get(Cities.Urziceni), 85.0);
        g.add(cities.get(Cities.Urziceni), cities.get(Cities.Hirsova), 98.0);
        g.add(cities.get(Cities.Hirsova), cities.get(Cities.Eforie), 86.0);
        g.add(cities.get(Cities.Urziceni), cities.get(Cities.Vaslui), 142.0);
        g.add(cities.get(Cities.Vaslui), cities.get(Cities.Iasi), 92.0);
        g.add(cities.get(Cities.Iasi), cities.get(Cities.Neamt), 87.0);


        return g;
    }
}
