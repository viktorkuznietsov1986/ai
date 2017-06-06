package vacuumworld;

/**
 * Created by Viktor on 6/5/17.
 */
public interface ActionFactory {
    Action newAction(Percept p);
}
