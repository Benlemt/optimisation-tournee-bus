import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    private int id;
    private List<Node> neighbors;
    private int probaGetOn;
    private int probaGetOff;


    public Node(int id, int probaGetOn, int probaGetOff) {
        this.neighbors = new ArrayList<Node>();
        this.id = id;
        this.probaGetOn = probaGetOn;
        this.probaGetOff = probaGetOff;
    }

    public int getId() {
        return this.id;
    }

    public List<Node> getNeighbors() {
        return this.neighbors;
    }

    public void addNeighbor(Node newNode) {
        this.neighbors.add(newNode);
    }

    // Proba management


    public int getProbaGetOn() {
        return this.probaGetOn;
    }

    public int getProbaGetOff() {
        return this.probaGetOff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getId() == node.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
