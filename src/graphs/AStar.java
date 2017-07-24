package graphs;

import java.util.*;

/**
 * Created by Viktor on 7/1/17.
 */
public class AStar extends Search {

    private Set<Node> nodes = new HashSet<>();
    private Set<Node> explored = new HashSet<>();

    public AStar(Problem problem, State start, State end, Heuristics h) throws FailureException {
        if (problem == null)
            throw new IllegalArgumentException();

        if (start == null)
            throw new IllegalArgumentException();

        if (end == null)
            throw new IllegalArgumentException();

        if (h == null)
            throw new IllegalArgumentException();

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> (int) (o1.getPathCost() - o2.getPathCost()));
        Node s = new Node();
        s.pathCost = 0.0;
        s.state = start;
        s.heuristics = h;
        q.add(s);
        nodes.add(s);


        while (!q.isEmpty()) {
            Node n = q.poll();

            if (explored.contains(n)) {
                continue;
            }

            explored.add(n);

            State state = n.getState();

            if (state.equals(end)) {
                searchTree = n;
                break;
            }

            visit(problem, q, n, h);
        }

        if (searchTree != null) {
            cost = searchTree.pathCost;
        }
        else {
            throw new FailureException();
        }
    }

    private void visit(Problem problem, Queue<Node> q, Node u, Heuristics h) {

        List<Action> actions = problem.getActions(u.getState());

        for (Action a : actions) {
            Node childNode = u.getChildNode(problem, a, h);

            if (!nodes.contains(childNode)) {
                q.add(childNode);
            }

        }
    }
}
