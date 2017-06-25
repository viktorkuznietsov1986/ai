package graphs;

import java.util.List;

/**
 * Created by Viktor on 6/23/17.
 * Base interface for each graph searching algorithm.
 */
public interface Search {
    /**
     * Gets the total cost of the path found.
     * @return the total cost of the path found.
     */
    double getCost();

    /**
     * Gets the list of vertexes with the exact path.
     * @return the list of vertexes with the exact path.
     */
    List<Integer> getPath();
}
