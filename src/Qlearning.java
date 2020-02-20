import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Qlearning {

    private HashMap<State, Map<Node, Integer>> qValues = new HashMap<>();
    private double alpha = 0.2;
    private double gamma = 0.9;
    private double epsilon = 0.2;
    private Engine engine;

    public Qlearning(Engine engine) {
        this.engine = engine;
    }

    public void run() {
        State saveState = engine.getState(); // S
        List<Node> nextNodes = engine.getState().getCurrentNode().getNeighbors();
        Node chosenNode;



        if (new Random().nextDouble() < 1 - this.epsilon) {
            // We choose an action for best Q value
            chosenNode = nextNodes.get(new Random().nextInt(nextNodes.size()));

        }
        else {
            chosenNode = nextNodes.get(new Random().nextInt(nextNodes.size()));
        }

        engine.moveBus(chosenNode); // S'

        int reward = engine.getState().getBus().getScore() - saveState.getBus().getScore(); // R = new_score - old_score

    }



}
