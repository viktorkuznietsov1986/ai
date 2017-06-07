package vacuumworld;

/**
 * Created by Viktor on 6/4/17.
 */
public class VacuumWorld {

    protected boolean[][] configuration;

    public VacuumWorld(boolean[][] initialConfig) {
        configuration = new boolean[initialConfig.length][];

        for (int i = 0; i < initialConfig.length; ++i) {
            configuration[i] = new boolean[initialConfig[i].length];

            for (int j = 0; j < initialConfig[i].length; ++j) {
                configuration[i][j] = initialConfig[i][j];
            }
        }
    }

    public boolean isSectorDirty(Position p) {

        return configuration[p.getY()][p.getX()];
    }



}
