import javafx.util.Pair;

import java.lang.reflect.Parameter;

/**
 * Created by noble on 2017-09-07.
 */

public class PairwiseDisjointSets {

    // Constants
    private static final int INITIAL_SINGLETON_SET_SIZE = 1;

    // Private instance variables
    private int     _numberOfElements;
    private int[]   _parentTree;

    // Private getter/setter
    private int numberOfElements() {
        return this._numberOfElements;
    }
    private void setNumberOfElements(int newNumberOfElements) {
        this._numberOfElements = newNumberOfElements;
    }
    private int[] parentTree() {
        return this._parentTree;
    }
    private void setParentTree(int[] newParentTree) {
        this._parentTree = newParentTree;
    }

    // Private methods
    private int parentOf(int aMember) {
        return this.parentTree()[aMember];
    }
    private void setParentOf(int aChildMember, int newParentMember) {
        this.parentTree()[aChildMember] = newParentMember;
    }
    private boolean parentDoesExist(int aMember) {
        return (this.parentOf(aMember) >= 0);
    }
    private int sizeOfSetFor(int aRoot) {
        return -this.parentOf(aRoot);
    }
    private void setSizeOfSetFor(int aRoot, int newSize) {
        this.setParentOf(aRoot, -newSize);
    }

    // Constructor
    public PairwiseDisjointSets(int givenNumberOfElements) {
        this.setNumberOfElements(givenNumberOfElements);
        this.setParentTree(new int[this.numberOfElements()]);
        for (int rootOfSingletonSet =0;
                rootOfSingletonSet < this.numberOfElements();
                rootOfSingletonSet++)
        {
            this.setSizeOfSetFor(rootOfSingletonSet, INITIAL_SINGLETON_SET_SIZE);
        }
    }

    public int find(int aMember) {
        int rootCandidate = aMember;
        while (this.parentDoesExist(rootCandidate)) {
            rootCandidate = this.parentOf(rootCandidate);
        }
        int root = rootCandidate;

        // Apply Collapsing Rule
        int child = aMember;
        int parent = this.parentOf(child);
        if (parent >= 0) {
            while (parent != root) {
                this.setParentOf(child, root);
                child = parent;
                parent = this.parentOf(child);
            }
        }
        return root;
    }
    public void union(int aMemberA, int aMemberB) {
        int rootOfSetA = find(aMemberA);
            // the root index of the set which aMemberA belongs to.
        int rootOfSetB = find(aMemberB);
            // the root index of the set which aMemberA belongs to.

        // Each root has the size of the tree as the negative value
        int sizeOfSetA = this.sizeOfSetFor(rootOfSetA);
        int sizeOfSetB = this.sizeOfSetFor(rootOfSetB);

        // Apply Weighting Rule.
        if (sizeOfSetA < sizeOfSetB) {
            // Make the root of setA as a child of the root of setB
            this.setParentOf(rootOfSetA, rootOfSetB);
            this.setSizeOfSetFor(rootOfSetB, (sizeOfSetA + sizeOfSetB));
        }
        else {
            // Make the root of setB as a child of the root of setA
            this.setParentOf(rootOfSetB, rootOfSetA);
            this.setSizeOfSetFor(rootOfSetA, (sizeOfSetA + sizeOfSetB));
        }
    }
}