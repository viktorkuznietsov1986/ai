package environment.romania;

import graphs.Heuristics;
import graphs.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Viktor on 7/1/17.
 */
public class BucharestHeuristics implements Heuristics {
    private static final Map<Cities, Double> heuristics = new HashMap<Cities, Double>();

    static {
        heuristics.put(Cities.Arad, 366.0);
        heuristics.put(Cities.Bucharest, 0.0);
        heuristics.put(Cities.Craiova, 160.0);
        heuristics.put(Cities.Drobeta, 242.0);
        heuristics.put(Cities.Eforie, 161.0);
        heuristics.put(Cities.Fagaras, 176.0);
        heuristics.put(Cities.Giurgiu, 77.0);
        heuristics.put(Cities.Hirsova, 151.0);
        heuristics.put(Cities.Iasi, 226.0);
        heuristics.put(Cities.Lugoj, 244.0);
        heuristics.put(Cities.Mehadia, 241.0);
        heuristics.put(Cities.Neamt, 234.0);
        heuristics.put(Cities.Oradea, 380.0);
        heuristics.put(Cities.Pitesti, 100.0);
        heuristics.put(Cities.RimnicuVilcea, 193.0);
        heuristics.put(Cities.Sibiu, 253.0);
        heuristics.put(Cities.Timisoara, 329.0);
        heuristics.put(Cities.Urziceni, 80.0);
        heuristics.put(Cities.Vaslui, 199.0);
        heuristics.put(Cities.Zerind, 374.0);
    }


    @Override
    public double getCost(Node n) {
        if (n == null)
            throw new IllegalArgumentException();

        return heuristics.get(n.getState().getState());
    }
}
