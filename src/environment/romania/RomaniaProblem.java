package environment.romania;

import graphs.Action;
import graphs.Problem;
import graphs.State;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Viktor on 6/28/17.
 */
public class RomaniaProblem implements Problem {
    
    private Map<String, Double> states = new HashMap<>();
    private List<Action>[] actions = new List[Cities.values().length];

    Map<Cities, Integer> cities = new HashMap<>();

    public RomaniaProblem() {
        int i = 0;

        for (Cities c : Cities.values()) {
            cities.put(c, i++);
        }

        buildStates();
        buildActions();
    }
    
    private void buildStates() {
        addState(Cities.Oradea, Cities.Zerind, 71.0);
        addState(Cities.Zerind, Cities.Arad, 75.0);
        addState(Cities.Oradea, Cities.Sibiu, 151.0);
        addState(Cities.Arad, Cities.Sibiu, 140.0);
        addState(Cities.Arad,Cities.Timisoara,118.0);
        addState(Cities.Timisoara,Cities.Lugoj,111.0);
        addState(Cities.Lugoj,Cities.Mehadia,70.0);
        addState(Cities.Mehadia,Cities.Drobeta,75.0);
        addState(Cities.Drobeta,Cities.Craiova,120.0);
        addState(Cities.Craiova,Cities.RimnicuVilcea,146.0);
        addState(Cities.Craiova,Cities.Pitesti,138.0);
        addState(Cities.Sibiu,Cities.RimnicuVilcea,80.0);
        addState(Cities.RimnicuVilcea,Cities.Pitesti,97.0);
        addState(Cities.Pitesti,Cities.Bucharest,101.0);
        addState(Cities.Sibiu,Cities.Fagaras,99.0);
        addState(Cities.Fagaras,Cities.Bucharest,211.0);
        addState(Cities.Bucharest,Cities.Giurgiu,90.0);
        addState(Cities.Bucharest,Cities.Urziceni,85.0);
        addState(Cities.Urziceni,Cities.Hirsova,98.0);
        addState(Cities.Hirsova,Cities.Eforie,86.0);
        addState(Cities.Urziceni,Cities.Vaslui,142.0);
        addState(Cities.Vaslui,Cities.Iasi,92.0);
        addState(Cities.Iasi,Cities.Neamt,87.0);

    }
    
    private void addState(Cities first, Cities second, double cost) {
        states.put(first.toString()+second.toString(), cost);
        states.put(second.toString()+first.toString(), cost);
    }
    
    private void buildActions() {
        for (int i = 0; i < actions.length; ++i) {
            actions[i] = new LinkedList<>();
        }

        addAction(Cities.Oradea, Cities.Zerind);
        addAction(Cities.Oradea, Cities.Sibiu);
        addAction(Cities.Zerind, Cities.Arad);
        addAction(Cities.Arad, Cities.Timisoara);
        addAction(Cities.Arad, Cities.Sibiu);
        addAction(Cities.Timisoara, Cities.Lugoj);
        addAction(Cities.Lugoj, Cities.Mehadia);
        addAction(Cities.Mehadia, Cities.Drobeta);
        addAction(Cities.Drobeta, Cities.Craiova);
        addAction(Cities.Craiova, Cities.RimnicuVilcea);
        addAction(Cities.Craiova, Cities.Pitesti);
        addAction(Cities.Sibiu, Cities.Fagaras);
        addAction(Cities.Sibiu, Cities.RimnicuVilcea);
        addAction(Cities.Fagaras, Cities.Bucharest);
        addAction(Cities.RimnicuVilcea, Cities.Pitesti);
        addAction(Cities.Pitesti, Cities.Bucharest);
        addAction(Cities.Bucharest, Cities.Giurgiu);
        addAction(Cities.Bucharest, Cities.Urziceni);
        addAction(Cities.Urziceni, Cities.Hirsova);
        addAction(Cities.Hirsova, Cities.Eforie);
        addAction(Cities.Urziceni, Cities.Vaslui);
        addAction(Cities.Vaslui, Cities.Iasi);
        addAction(Cities.Iasi, Cities.Neamt);
    }

    private void addAction(Cities from, Cities to) {
        actions[cities.get(from)].add(() -> to);
        actions[cities.get(to)].add(() -> from);
    }

    @Override
    public List<Action> getActions(State state) {
        return actions[cities.get(state.getState())];
    }

    @Override
    public State getResult(State parentState, Action action) {

        String key = buildKey(parentState, action);

        if (!states.containsKey(key))
            throw new IllegalStateException();

        Cities to = (Cities)action.getAction();

        return new State() {
            @Override
            public Object getState() {
                return to;
            }
        };
    }

    @Override
    public double getStepCost(State parentState, Action action) {
        String key = buildKey(parentState, action);
        return states.get(key);
    }

    private String buildKey(State parentState, Action action) {
        if (parentState == null)
            throw new IllegalArgumentException();

        if (action == null)
            throw new IllegalArgumentException();

        Cities from = (Cities)parentState.getState();
        Cities to = (Cities)action.getAction();

        return from.toString()+to.toString();
    }
}
