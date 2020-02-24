import java.util.*;

public class Qlearning {

    private Map<State, Map<Node, Double>> qValues = new HashMap<>();
    private double alpha = 0.2;
    private double gamma = 0.9;
    private double epsilon = 0.2;
    private Engine engine;

    public Qlearning(Engine engine) {
        this.engine = engine;

        //Initialization of the q-values of all the possible states. A state is a bus at a certain node j with a number of passengers i
        // and the actions are the nodes k possible from this state
        for (int i = 0; i <= engine.getState().getBus().getPassengersMax(); i++) {
            Bus bus = new Bus(engine.getState().getBus().getPassengersMax());
            bus.setPassengers(i);

            for (int j = 0; j < engine.getMap().size(); j++) {
                Node node = engine.getMap().get(j);
                State state = new State(bus, node);
                Map<Node, Double> nextNodesValues = new HashMap<>();
                for (int k = 0; k < node.getNeighbors().size(); k++) {
                    Node nextNode = node.getNeighbors().get(k);
                    nextNodesValues.put(nextNode, 0.0);
                }
                this.qValues.put(state, nextNodesValues);
            }
        }
    }

    public void run() {
        State saveState = engine.getState();
        Node chosenNode;
        if (new Random().nextDouble() < 1 - this.epsilon) {
            chosenNode = Collections.min(qValues.get(saveState).entrySet(), Map.Entry.comparingByValue()).getKey();
        } else {
            List<Node> nextNodes = saveState.getCurrentNode().getNeighbors();
            chosenNode = nextNodes.get(new Random().nextInt(nextNodes.size()));
        }
        engine.moveBus(chosenNode);

        // Le reward correspond au nombre de personnes qui ne sont pas montés dans le bus
        int reward = Math.abs(engine.getState().getBus().getScore());

        double newQvalue = (1 - this.alpha) * this.qValues.get(saveState).get(chosenNode) + this.alpha * (reward + this.gamma * Collections.min(this.qValues.get(engine.getState()).entrySet(), Map.Entry.comparingByValue()).getValue());
        this.qValues.get(saveState).replace(chosenNode, newQvalue);
    }

    public Map<State, Map<Node, Double>> getqValues() {
        return qValues;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (State state : qValues.keySet()) {
            Map<Node, Double> nodes = qValues.get(state);

            for (Node node : nodes.keySet()) {
                result.append(state).append(" | ").append(node).append(" | ").append(nodes.get(node)).append("\n");
            }
        }
        return result.toString();
    }
}
