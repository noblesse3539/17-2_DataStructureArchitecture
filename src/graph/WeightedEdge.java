package graph;

/**
 * Created by noble on 2017-09-27.
 */
public class WeightedEdge extends Edge implements Comparable<WeightedEdge>{
    private static final int DEFAULT_WEIGHT = 0;
    private int _weight;

    // Getters & Setters: Encapsulation of private instance variables
    public int weight() {
        return this._weight;
    }
    public void setWeight(int newWeight) {
        this._weight = newWeight;
    }

    //Constructor
    public WeightedEdge(int givenTailVertex, int givenHeadVertex) {
        super(givenTailVertex, givenHeadVertex);
        this.setWeight(WeightedEdge.DEFAULT_WEIGHT);
    }

    public WeightedEdge(int givenTailVertex, int givenHeadVertex, int givenWeight) {
        super(givenTailVertex, givenHeadVertex);
        this.setWeight(givenWeight);
    }

    // Implementation of Interface Comparable
    @Override
    public int compareTo(WeightedEdge otherEdge) {
        if (this.weight() < otherEdge.weight()) {
            return -1;
        }
        else if (this.weight() > otherEdge.weight()) {
            return +1;
        }
        else {
            return 0;
        }
    }

}
