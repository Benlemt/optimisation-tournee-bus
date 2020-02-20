import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Engine engine = new Engine();
        List<Node> map = engine.getMap();
        GraphicsEngine graphicsEngine = new GraphicsEngine(map);

        while (true) {

            // Engine management
            Node newNode = engine.getMap().get(new Random().nextInt(engine.getMap().size()));
            engine.moveBus(newNode);


            // Graphics management
            int currentNodeID = newNode.getId();
            String score = engine.getInfos() + " | Place dans le bus : " + Integer.toString(engine.getState().getBus().getPassengers()) + " Score : " + engine.getState().getBus().getScore();
            graphicsEngine.setCurrentNode(currentNodeID, score);

            // Pause
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            graphicsEngine.deleteCurrentNode(currentNodeID);


        }
    }
}
