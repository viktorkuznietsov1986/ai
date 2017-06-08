package vacuumworld;

import java.util.Random;

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

    public boolean isSectorAvailable(Position p) {
        return (p.getY() < configuration.length) && (p.getX() < configuration[p.getY()].length);
    }

    public boolean isSectorDirty(Position p) {

        return configuration[p.getY()][p.getX()];
    }

    public void cleanSector(Position p) {
        configuration[p.getY()][p.getX()] = false;
    }

    public int getNumberOfCleanCells() {
        int number = 0;

        for (int i = 0; i < configuration.length; ++i) {
            for (int j = 0; j < configuration[i].length; ++j) {
                if (!configuration[i][j]) {
                    ++number;
                }
            }
        }

        return number;
    }

    public void generateRandormDirt() {
        int y = configuration.length;

        Random r = new Random();
        y = r.nextInt(y);

        int x = configuration[y].length;
        x = r.nextInt(x);

        boolean isDirty = r.nextBoolean();

        configuration[y][x] = isDirty;
    }



}
