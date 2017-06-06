package vacuumworld;

/**
 * Created by Viktor on 6/4/17.
 * Agent for vacuum cleaner in vacuum world.
 */
public abstract class Agent {

    private ActionFactory actionFactory;

    public Agent(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    /**
     * Act according to the percept.
     * @param p percept.
     */
    public void perform(Percept p) {
        Action action = actionFactory.newAction(p);
        action.perform();
    }
}
