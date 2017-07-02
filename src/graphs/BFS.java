package graphs;

import java.util.*;

/**
 * Created by Viktor on 6/23/17.
 * Implementation of breadth-first search method.
 */
public class BFS extends Search {

    private Set<Node> nodes = new HashSet<>();

    public BFS(Problem problem, State start, State end) throws FailureException {
        if (problem == null)
            throw new IllegalArgumentException();

        if (start == null)
            throw new IllegalArgumentException();

        if (end == null)
            throw new IllegalArgumentException();


        Queue<Node> q = new LinkedList<>();
        Node n = new Node();
        n.parent = null;
        n.state = start;

        q.add(n);


        while (!q.isEmpty()) {
            n = q.poll();

            if (nodes.contains(n)) {
                continue;
            }

            nodes.add(n);

            if (n.getState().equals(end)) {
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
