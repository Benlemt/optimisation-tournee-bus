import java.util.List;
import java.util.Random;

public class Engine {

    private State state;
    private List<Node> map;
    int getOffPassengers;
    int getOnPassengers;

    public Engine() {
        Bus bus = new Bus(20);
        this.map = new Clique(5).getListNode();
        this.state = new State(bus, this.map.get(0));
    }


    public void moveBus(Node newCurrentNode) {

        this.state = new State(this.state.getBus().getCopy(), newCurrentNode);

        this.getOffPassengers = new Random().nextInt(newCurrentNode.getProbaGetOff());
        this.getOnPassengers = new Random().nextInt(newCurrentNode.getProbaGetOn());

        this.state.getOff(getOffPassengers);
        this.state.getOn(getOnPassengers);

    }

    public String getInfos() {
        return "(- " + this.getOffPassengers + " ; + " + this.getOnPassengers + ")";
    }

    public State getState() {
        return state;
    }

    public List<Node> getMap() { return this.map; }

    @Override
    public String toString() {
        return "Engine{" +
                "state=" + state +
                '}';
    }
}
