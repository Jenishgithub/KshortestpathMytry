import java.util.List;

import com.libraryclasses.BaseVertex;
import com.libraryclasses.DijkstraShortestPathAlg;
import com.libraryclasses.Graph;
import com.libraryclasses.MyGraph;
import com.libraryclasses.Path;
import com.libraryclasses.VariableGraph;
import com.libraryclasses.YenTopKShortestPathsAlg;

public class MainKSP {
	// static Graph graph = new VariableGraph("data/test_6_2");
	static MyGraph graph = new VariableGraph("data/test_50");

	public static void main(String[] args) {

		// testDijkstraShortestPathAlg();
		testYenShortestPathsAlg();
		// testYenShortestPathsAlg2();
		// testYenShortestPathsAlg4MultipleGraphs();
	}

	public static void testDijkstraShortestPathAlg() {
		System.out.println("Testing Dijkstra Shortest Path Algorithm!");
		DijkstraShortestPathAlg alg = new DijkstraShortestPathAlg(graph);
		System.out.println(alg.getShortestPath(graph.getVertex(4),
				graph.getVertex(5)));
	}

	public static void testYenShortestPathsAlg() {
		System.out.println("Testing batch processing of top-k shortest paths!");
		YenTopKShortestPathsAlg yenAlg = new YenTopKShortestPathsAlg(graph);
		List<Path> shortest_paths_list = yenAlg.getShortestPaths(
				graph.getVertex(0), graph.getVertex(5), 3);

		for (Path path : shortest_paths_list) {

			List<BaseVertex> vertexList = path.getVertexList();
			for (BaseVertex baseVertex : vertexList) {
				System.out.print(baseVertex);
			}
			System.out.println(" routes ");
		}

//		System.out.println(":" + shortest_paths_list);
//		System.out.println(yenAlg.getResultList().size());
	}

	public static void testYenShortestPathsAlg2() {
		System.out.println("Obtain all paths in increasing order! - updated!");
		YenTopKShortestPathsAlg yenAlg = new YenTopKShortestPathsAlg(graph,
				graph.getVertex(4), graph.getVertex(5));
		int i = 0;
		while (yenAlg.hasNext()) {
			System.out.println("Path " + i++ + " : " + yenAlg.next());
		}

		System.out.println("Result # :" + i);
		System.out.println("Candidate # :" + yenAlg.getCadidateSize());
		System.out.println("All generated : " + yenAlg.getGeneratedPathSize());
	}

	public static void testYenShortestPathsAlg4MultipleGraphs() {
		System.out.println("Graph 1 - ");
		YenTopKShortestPathsAlg yenAlg = new YenTopKShortestPathsAlg(graph,
				graph.getVertex(4), graph.getVertex(5));
		int i = 0;
		while (yenAlg.hasNext()) {
			System.out.println("Path " + i++ + " : " + yenAlg.next());
		}

		System.out.println("Result # :" + i);
		System.out.println("Candidate # :" + yenAlg.getCadidateSize());
		System.out.println("All generated : " + yenAlg.getGeneratedPathSize());

		// /
		System.out.println("Graph 2 - ");
		graph = new VariableGraph("data/test_6_1");
		YenTopKShortestPathsAlg yenAlg1 = new YenTopKShortestPathsAlg(graph);
		List<Path> shortest_paths_list = yenAlg1.getShortestPaths(
				graph.getVertex(4), graph.getVertex(5), 100);
		System.out.println(":" + shortest_paths_list);
		System.out.println(yenAlg1.getResultList().size());
	}
}
