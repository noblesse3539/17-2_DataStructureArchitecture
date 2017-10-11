package graph;

/**
 * Created by noble on 2017-09-27.
 */
public class UndirectedAdjacencyMatrixGraph<E extends Edge> implements Graph<E> {

    // Constants
    private static final int EDGE_EXIST =1;
    private static final int EDGE_NONE = 0;

    // Private instance varaibles
    private int     _numberOfVertices;
    private int     _numberOfEdges;
    private int[][] _adjacency;

    // Getters & Setters: Encapsulation of private instance variables
    @Override
    public int numberOfVertices() {
        return this._numberOfVertices;
    }
    protected void setNumberOfVertices(int newNumberOfVertices) {
        this._numberOfVertices = newNumberOfVertices;
    }

    @Override
    public int numberOfEdges() {
        return this._numberOfEdges;
    }
    protected void setNumberOfEdges(int newNumberOfEdges) {
        this._numberOfEdges = newNumberOfEdges;
    }

    protected int[][] adjacency() {
        return this._adjacency;
    }
    protected void setAdjacency(int[][] newAdjacency) {
        this._adjacency = newAdjacency;
    }

    // Getting & Setting an element of Adjacency Matrix
    protected int adjacencyOfEdge(int tailVertex, int headVeratex) {
        return this.adjacency()[tailVertex][headVeratex];
    }
    protected void setAdjacencyOfEdgeAs(int tailVertex, int headVertex, int anAdjacencyOfEdge) {
        this.adjacency()[tailVertex][headVertex] = anAdjacencyOfEdge;
    }
    /*아래 함수는 상속 받는 class에서 사용되지 않는다. Matrix에서 edge 존재를 나타내는 값이 달라지기 때문*/
    private void setAdjacencyOfEdgeAsExist(int tailVertex, int headVertex) {
        this.setAdjacencyOfEdgeAs(tailVertex, headVertex, UndirectedAdjacencyMatrixGraph.EDGE_EXIST);
    }
    protected void setAdjacencyOfEdgeAsNone(int tailVertex, int headVertex) {
        this.setAdjacencyOfEdgeAs(tailVertex, headVertex, UndirectedAdjacencyMatrixGraph.EDGE_NONE);
    }

    // Constructor
    public UndirectedAdjacencyMatrixGraph(int givenNumberOfVertices) {
        this.setNumberOfVertices(givenNumberOfVertices);
        this.setNumberOfEdges(0);
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]);
        for( int tailVertex =0; tailVertex < this.numberOfVertices(); tailVertex++) {
            for (int headVertex = 0; headVertex < this.numberOfVertices(); headVertex++){
                this.setAdjacencyOfEdgeAsNone(tailVertex, headVertex);
                // only for the class "UndirectedAdjacencyMatrixGraph"
            }

        }
    }
    /* 상속된 클래스의 생성자에 사용*/
    protected UndirectedAdjacencyMatrixGraph() {
    }
    // Protected method
    protected boolean adjacencyOfEdgeDoesExist(int tailVertex, int headVertex) {
        return (this.adjacencyOfEdge(tailVertex, headVertex) !=
                UndirectedAdjacencyMatrixGraph.EDGE_NONE);
    }

    // Public methods
    @Override
    public boolean vertexDoesExist(int aVertex) {
        return (aVertex >= 0 && aVertex < this.numberOfVertices());
    }
    @Override
    public boolean edgeIsValid(int aTailVertex, int aHeadVertex) {
        return (this.vertexDoesExist(aTailVertex) &&
                this.vertexDoesExist(aHeadVertex)       );
    }
    @Override
    public boolean edgeIsValid(E anEdge) {
        if (anEdge != null) {
            return (this.edgeIsValid(anEdge.tailVertex(), anEdge.headVertex()));
        }
        return false;
    }
    @Override
    public boolean edgeDoesExist(int aTailVertex, int aHeadVertex) {
        if (this.edgeIsValid(aTailVertex, aHeadVertex)) {
            return (this.adjacencyOfEdgeDoesExist(aTailVertex,aHeadVertex));
        }
        return false;
    }
    @Override
    public boolean edgeDoesExist(E anEdge) {
        if (anEdge != null) {
            return this.edgeDoesExist(anEdge.tailVertex(), anEdge.headVertex());
        }
        return false;
    }

    /*undirected/unweighted 그래프에서의 addEdge*/
    @Override
    public boolean addEdge(E anEdge) {
        if (anEdge != null) {
            if(this.edgeIsValid(anEdge) && !this.edgeDoesExist(anEdge)) {
                int tailVertex = anEdge.tailVertex();
                int headVertex = anEdge.headVertex();
                this.setAdjacencyOfEdgeAsExist(tailVertex, headVertex);
                this.setAdjacencyOfEdgeAsExist(headVertex, tailVertex);
                this.setNumberOfEdges(this.numberOfEdges()+1);
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E edge(int aTailVertex, int aHeadVertex) {
        if (this.edgeDoesExist(aTailVertex, aHeadVertex)) {
            return (E) new Edge(aTailVertex, aHeadVertex);
        }
        return null;
    }
}
