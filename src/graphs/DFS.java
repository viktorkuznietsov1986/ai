package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Viktor on 6/29/17.
 */
public class DFS extends Search {

    private Set<Node> nodes = new HashSet<>();

    public DFS(Problem problem, State start, State end) throws FailureException {

        Node s = new Node();
        s.state = start;
        s.pathCost = 0.0;

        Stack<Node> q = new Stack<>();
        q.push(s);

        while (!q.empty()) {
            Node n = q.pop();

            if (n.getState().equals(end)) {
                searchTree = n;
                break;
            }

            if (!nodes.contains(n)) {
                visit(problem, q, n);
            }

        }

        if (searchTree != null) {
            cost = searchTree.pathCost;
        }
        else {
            throw new FailureException();
        }
    }

    private void visit(Problem problem, Stack<Node> q, Node u) {
        nodes.add(u);

        List<Action> actions = problem.getActions(u.getState());

        for (Action a : actions) {
            Node v = u.getChildNode(problem, a);

            if (nodes.contains(v))
                continue;

            q.push(v);
        }
    }

}
