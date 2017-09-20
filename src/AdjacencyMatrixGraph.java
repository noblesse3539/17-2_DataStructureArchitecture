
public class AdjacencyMatrixGraph {

	// Private constants
	private static final int EDGE_EXIST = 1;
	private static final int EDGE_NONE = 0;
	
	// Private instance variables
	private int 	_numberOfVertices;
	private int 	_numberOfEdges;
	private int[][] _adjacency;
	
	public AdjacencyMatrixGraph(int givenNumberOfVertices) {
		this.setNumberOfVertices(givenNumberOfVertices);
		this.setNumberOfEdges(0);
		this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]);
		for (int tailVertex = 0; tailVertex < this.numberOfVertices(); tailVertex++ ) {
			for (int headVertex = 0; headVertex < this.numberOfVertices(); headVertex++) {
				this.adjacency()[tailVertex][headVertex] = AdjacencyMatrixGraph.EDGE_NONE;
			}
		}
	}
	
	// Public Getters & Setters
	public int numberOfVertices() {
		return this._numberOfVertices;
	}
	public int numberOfEdges () {
		return this._numberOfEdges;
	}

	// Private Getters & Setters
	private void setNumberOfVertices (int newNumberOfVertices) {
		this._numberOfVertices = newNumberOfVertices;
	}
	private void setNumberOfEdges (int newNumberOfEdges) {
		this._numberOfEdges = newNumberOfEdges;
	}
	private int[][] adjacency() {
		return this._adjacency;
	}
	private void setAdjacency(int[][] newAdjacency) {
		this._adjacency = newAdjacency;
	}
	
	// Private Methods
	private boolean adjacencyOfEdgeDoesExist(int tailVertex, int headVertex) {
		return (this.adjacency()[tailVertex][headVertex] !=
				AdjacencyMatrixGraph.EDGE_NONE); 	// 메트릭스의 요소가 0이 아닐경우 true
	}
	
	public boolean vertexDoesExist (int aVertex) {
		return (aVertex >= 0 && aVertex < this.numberOfVertices());
	}
	
	public boolean edgeDoesExist (Edge anEdge) {
		if (anEdge != null) {
			int tailVertex = anEdge.tailVertex();
			int headVertex = anEdge.headVertex();
			if (this.vertexDoesExist(tailVertex) && this.vertexDoesExist(headVertex)) {
				return (this.adjacencyOfEdgeDoesExist(tailVertex, headVertex));
			}
		}
		return false;
	}
	public boolean addEdge (Edge anEdge) {
		if (anEdge != null) {
			int tailVertex = anEdge.tailVertex();
			int headVertex = anEdge.headVertex();
			if ( this.vertexDoesExist(tailVertex) && this.vertexDoesExist(headVertex) ) {
				if (!this.adjacencyOfEdgeDoesExist(tailVertex, headVertex)) {
					this.adjacency()[tailVertex][headVertex] = AdjacencyMatrixGraph.EDGE_EXIST;
					this.adjacency()[headVertex][tailVertex] = AdjacencyMatrixGraph.EDGE_EXIST;
					this.setNumberOfEdges(this.numberOfEdges()+1);
					return true;
				}
			}
		}
		return false;
	}

}
