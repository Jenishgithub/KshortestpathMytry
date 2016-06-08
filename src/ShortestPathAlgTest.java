import com.libraryclasses.DijkstraShortestPathAlg;
import com.libraryclasses.Graph;

/**
 * TODO Need to redo!
 * 
 * @author <a href='mailto:Yan.Qi@asu.edu'>Yan Qi</a>
 * @version $Revision: 784 $
 * @latest $Id: ShortestPathAlgTest.java 784 2009-06-19 20:08:40Z qyan $
 */
public class ShortestPathAlgTest {
	private Graph graph = null;

	/**
	 * @throws java.lang.Exception
	 */

	public void setUp() throws Exception {
		// Import the graph from a file
		graph = new Graph("data/test_50");
	}

	public void testShorstPathAlg() {
		System.out.println("Testing Dijkstra Algorithm.");
		DijkstraShortestPathAlg alg = new DijkstraShortestPathAlg(graph);
		System.out.println(alg.getShortestPath(graph.getVertex(0),
				graph.getVertex(38)));
	}
}
