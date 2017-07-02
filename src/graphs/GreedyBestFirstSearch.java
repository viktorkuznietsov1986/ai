package graphs;

import java.util.*;

/**
 * Created by Viktor on 7/1/17.
 */
public class GreedyBestFirstSearch extends Search {

    private Set<Node> nodes = new HashSet<>();

    public GreedyBestFirstSearch(Problem problem, State start, State end, Heuristics h) throws FailureException {
        if (problem == null)
            throw new IllegalArgumentException();

        if (start == null)
            throw new IllegalArgumentException();

        if (end == null)
            throw new IllegalArgumentException();

        if (h == null)
            throw new IllegalArgumentException();

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> (int) (h.getCost(o1) - h.getCost(o2)));
        Node s = new Node();
        s.pathCost = 0.0;
        s.state = start;
        q.add(s);
        nodes.add(s);


        while (!q.isEmpty()) {
            Node n = q.poll();
            State state = n.getState();

            if (state.equals(end)) {
                searchTree = n;
                break;
            }

            visit(problem, q, n);
        }

        if (searchTree != null) {
            cost = searchTree.pathCost;
        }
        else {
            throw new FailureException();
        }
    }

    private void visit(Problem problem, Queue<Node> q, Node u) {

        List<Action> actions = problem.getActions(u.getState());

        for (Action a : actions) {
            Node childNode = u.getChildNode(problem, a);

            if (!nodes.contains(childNode)) {
                q.add(childNode);
            }

        }
    }
}
