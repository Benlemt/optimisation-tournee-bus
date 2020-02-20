import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clique {

    private List<Node> listNode;

    public Clique(int nbNode) {
        this.listNode = new ArrayList<Node>();
        for(int i = 0; i < nbNode; i++) {

            int probaGetOn = new Random().nextInt(14) + 2; // From 2 to 15
            int probaGetOff = new Random().nextInt(9) + 2; // From 2 to 10

            addNode(new Node(i, probaGetOn, probaGetOff));
        }
    }

    private void addNode(Node newNode) {
        for (Node node : this.listNode) {
            node.addNeighbor(newNode);
            newNode.addNeighbor(node);
        }
        listNode.add(newNode);
    }

    public List<Node> getListNode() {
        return listNode;
    }
}
