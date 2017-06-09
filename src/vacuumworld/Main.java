package vacuumworld;

import vacuumworld.simulator.SimpleWorldSimpleReflexAgentGoPenaltyRunner;
import vacuumworld.simulator.SimpleWorldSimpleReflexAgentRunner;
import vacuumworld.simulator.SimpleWorldStateReflexAgentRunner;

/**
 * Created by evikuzn on 6/7/2017.
 */
public class Main {
    public static void main(String[] args) {

        //new SimpleWorldSimpleReflexAgentRunner().run();
        //new SimpleWorldSimpleReflexAgentGoPenaltyRunner().run();
        new SimpleWorldStateReflexAgentRunner().run();


    }
}
