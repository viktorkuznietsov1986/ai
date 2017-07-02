package graphs;

/**
 * Created by Viktor on 6/30/17.
 */
public class IterativeDeepingSearch extends Search {

    public IterativeDeepingSearch(Problem problem, State start, State end) throws FailureException {
        for (int depth = 0; true; ++depth) {
            try {
                Search s = new DepthLimitedSearch(problem, start, end, depth);
                searchTree = s.getSearchTree();
                cost = searchTree.pathCost;
                return;
            } catch (CutoffException e) {
                continue;
            } catch (FailureException e) {
                throw e;
            }
        }
    }
}
