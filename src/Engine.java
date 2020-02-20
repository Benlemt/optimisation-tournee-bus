import java.util.List;
import java.util.Random;

public class Engine {

    private State state;
    private List<Node> map;

    public Engine() {

        Bus bus = new Bus(20);
        this.map = new Clique(5).getListNode();
        this.state = new State(bus, this.map.get(0));

    }

    public void moveBus(Node newCurrentNode) {

        /**
        List<Node> neighborsNodes = this.state.getCurrentNode().getNeighbors();
        int newNodeID = new Random().nextInt(neighborsNodes.size());
        Node newCurrentNode = neighborsNodes.get(newNodeID);
        **/


        this.state.updateCurrentNode(newCurrentNode);

        int getOffPassengers = new Random().nextInt(newCurrentNode.getProbaGetOff());
        int getOnPassengers = new Random().nextInt(newCurrentNode.getProbaGetOn());

        System.out.println("GetOff" + getOffPassengers);
        System.out.println("GetOn" + getOnPassengers);

        this.state.getOff(getOffPassengers);
        this.state.getOn(getOnPassengers);

    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "state=" + state +
                '}';
    }
}
