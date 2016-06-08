import com.libraryclasses.DijkstraShortestPathAlg;
import com.libraryclasses.Graph;

public class MainDijkstra {
	public static void main(String[] args) {

		Graph graph = new Graph("data/test_50");
		System.out.println("Testing Dijkstra Algorithm.");
		DijkstraShortestPathAlg alg = new DijkstraShortestPathAlg(graph);
		System.out.println(alg.getShortestPath(graph.getVertex(0),
				graph.getVertex(38)));
	}
}
