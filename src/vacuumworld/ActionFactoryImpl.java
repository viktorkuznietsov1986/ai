package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 */
public class ActionFactoryImpl implements ActionFactory {
    private static ActionFactoryImpl instance = new ActionFactoryImpl();

    public static ActionFactoryImpl getInstance() {
        return instance;
    }

    private ActionFactoryImpl() {
    }

    @Override
    public Action newAction(Percept p) {
        return null;
    }
}
