package graphs;

/**
 * Factory interface for building random instances of problems.
 */
public interface ProblemFactory {
    /**
     * Generates the random instance of the problem.
     * @return the random instance of the problem.
     */
    Problem getRandomProblem();
}
