import java.util.Objects;

public class State {

    private Bus bus;
    private Node currentNode;

    public State(Bus bus, Node currentNode) {
        this.bus = bus;
        this.currentNode = currentNode;
    }

    // Bus management

    public void getOn(int waitingPassengers) {

        int remainingPassengers;

        if (this.bus.getPassengersMax() < waitingPassengers + this.bus.getPassengers()) {

            int addedPassengers = this.bus.getPassengersMax() - this.bus.getPassengers();
            remainingPassengers = waitingPassengers - addedPassengers;
            this.bus.addPassenger(addedPassengers);

        }
        else {

            this.bus.addPassenger(waitingPassengers);
            remainingPassengers = 0;

        }

        this.bus.addScore(remainingPassengers);

    }

    public void getOff(int getOffPassengers) {

        if (this.bus.getPassengers() < getOffPassengers) {
            this.bus.removePassenger(bus.getPassengers());
        }
        else {
            bus.removePassenger(getOffPassengers);
        }

    }

    // Node management

    public Node getCurrentNode() {
        return this.currentNode;
    }

    public void updateCurrentNode(Node newCurrentNode) {
        this.currentNode = newCurrentNode;
    }


    // Bus management


    public Bus getBus() {
        return bus;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return Objects.equals(getBus(), state.getBus()) &&
                Objects.equals(getCurrentNode(), state.getCurrentNode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBus(), getCurrentNode());
    }

    @Override
    public String toString() {
        return "State{" +
                "bus =" + bus.getPassengers() + " | " + bus.getScore() +
                ", currentNode=" + currentNode.getId() +
                '}';
    }
}
