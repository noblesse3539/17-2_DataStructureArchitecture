package list;

/**
 * Created by noble on 2017-09-20.
 */
public class LinkedNode<T> {

    // Private instance variables
    private T _element;
    private LinkedNode<T> _next;

    // Getters & Setters: Encapsulation of private instance variables
    public T element() {
        return this._element;
    }
    public void setElement(T newElement) {
        this._element = newElement;
    }
    public LinkedNode<T> next() {
        return this._next;
    }
    public void setNext(LinkedNode<T> newNext) {
        this._next = newNext;
    }

    // Constructors
    public LinkedNode() {
        this.setElement(null);
        this.setNext(null);
    }
    public LinkedNode(T givenElement, LinkedNode<T> givenNext) {
        this.setElement(givenElement);
        this.setNext(givenNext);
    }
}
