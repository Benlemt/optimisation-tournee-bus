import org.graphstream.algorithm.generator.FullGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

import java.util.List;

public class GraphicsEngine {

    private List<Node> map;
    private Graph graph;
    private FullGenerator generator;
    private Viewer viewer;

    public GraphicsEngine(List<Node> map) {
        this.map = map;
        this.graph = new SingleGraph("Graph");
        this.graph.addAttribute("ui.stylesheet", "url('style.css')");
        this.generator = new FullGenerator(false, false);
        this.generator.addSink(graph);
        this.generator.begin();

        for (int i = 0; i < this.map.size() - 1; i++) {
            this.generator.nextEvents();
        }
        this.generator.end();
        this.viewer = graph.display();
    }

    public void setCurrentNode(int i, String label) {
        this.graph.getNode(i).addAttribute("ui.class", "current");
        this.graph.getNode(i).addAttribute("ui.label", label);
    }

    public void deleteCurrentNode(int i) {
        this.graph.getNode(i).removeAttribute("ui.class");
        this.graph.getNode(i).removeAttribute("ui.label");
    }

}