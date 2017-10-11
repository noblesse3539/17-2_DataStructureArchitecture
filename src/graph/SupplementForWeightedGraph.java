package graph;

/**
 * Created by noble on 2017-09-27.
 */
public interface SupplementForWeightedGraph<E> {

    public int weightOfEdge(E anEdge);
    public int weightOfEdge(int aTailVertex, int aHeadVertex);
}
