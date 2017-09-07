
public class AppController {
	// Private instance variables
	private AdjacencyMatrixGraph _graph;
	
	// Getter & Setter
	private AdjacencyMatrixGraph graph() {
		return this._graph;
	}
	private void setGraph(AdjacencyMatrixGraph newGraph) {
		this._graph = newGraph;
	}
	
	public AppController() {	
		this.setGraph(null);;
	}
	private void inputAndMakeGraph() {
		AppView.outputLine("> 입력할 그래프의 vertex 수와 edge 수를 먼저 입력해야 합니다:");
		int numberOfVertices = this.inputNumberOfVertices();
		this.setGraph(new AdjacencyMatrixGraph(numberOfVertices));
		
		int numberOfEdges = this.inputNumberOfEdges();
		AppView.outputLine("");
		AppView.outputLine("> 이제부터 edge를 주어진 수 만큼 입력합니다.");
		
		int edgeCount = 0;
		while (edgeCount < numberOfEdges) {
			Edge edge = this.inputEdge();
			if (this.graph().edgeDoesExist(edge)) {
				AppView.outputLine("오류) 입력된 edge (" +
						edge.tailVertex() + "," + edge.headVertex() + ")는 그래프에 이미 존재합니다.");
			}
			else {
				edgeCount++;
				this.graph().addEdge(edge);
				AppView.outputLine("!새로운 edge (" +
						edge.tailVertex() + "," + edge.headVertex() + ") 가 그래프에 삽입되었습니다.");
			}
		}
	}
	private void showGraph() {
		
	}
	// run 이외의 다른 모든 함수는 private
	public void run() {
		AppView.outputLine("<<< 입력되는 그래프의 사이클 검사를 시작합니다 >>>");
		this.inputAndMakeGraph();
		this.showGraph();
		AppView.outputLine(""); //사이를 한 줄 띄우기로 한다.
		AppView.outputLine("<<< 그래프의 입력과 사이클 검사를 종료합니다 >>>");
	}
	
}
