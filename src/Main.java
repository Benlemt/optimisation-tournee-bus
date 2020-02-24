import java.util.List;

public class Main {

    public static void main(String[] args) {

        Engine engine = new Engine();
        Qlearning qlearning = new Qlearning(engine);
        List<Node> map = engine.getMap();
        GraphicsEngine graphicsEngine = new GraphicsEngine(map);

        while (true) {

            qlearning.run();

            // Graphics managementè
            int currentNodeID = engine.getState().getCurrentNode().getId();
            String score = engine.getInfos() + " | Passagers dans le bus : " + engine.getState().getBus().getPassengers() + " Score : " + engine.getState().getBus().getScore();
            graphicsEngine.setCurrentNode(currentNodeID, score);

            // Pause
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            graphicsEngine.deleteCurrentNode(currentNodeID);


        }
    }
}
