package kruskal;

/**
 * Created by noble on 2017-10-11.
 */
public class MinPriorityQ<E extends Comparable<E>> {

    // Constants
    private static final int DEFAULT_CAPACITY = 100;
    private static final int HEAP_ROOT = 1;

    // Private instace vatiables
    private int _size;
    private int _capacity;
    private E[] _heap;

    // Getters & Setters
    public int size() {
        return this._size;
    }
    private void setSize(int newSize) {
        this._size = newSize;
    }
    public int capacity() {
        return this._capacity;
    }
    private void setCapacity(int newCapacity) {
        this._capacity = newCapacity;
    }
    private E[] heap() {
        return this._heap;
    }
    private void setHeap(E[] newHeap) {
        this._heap = newHeap;
    }

    // Constructor
    public MinPriorityQ() {
        this(MinPriorityQ.DEFAULT_CAPACITY);
    }
    /* setHeap 에서 생성하는 객체가 Comparable임을 알고있으므로
    Object가 아닌 Comparable 객체를 생성함. Object일 경우 class casting 오류가 발생*/
    @SuppressWarnings("unchecked")
    public MinPriorityQ(int givenCapacity) {
        this.setCapacity(givenCapacity);
        this.setHeap((E[]) new Comparable[givenCapacity+1]);
        this.setSize(0);
    }

    // Public methods
    public boolean isEmpty() {
        return (this.size() == 0);
    }
    public boolean isFull() {
        return (this.size() == this.capacity());
    }

    public boolean add(E anElement) {
        if (this.isFull()) {
            return false;
        } else {
            int positionForAdd = this.size() + 1;
            this.setSize(positionForAdd);
            while ((positionForAdd > 1) &&
                    (anElement.compareTo(this.heap()[positionForAdd / 2]) < 0)) {
                 /* 힙의 맨 마지막 요소로 있다고 가정하고 그 요소의 부모와 값을 비교, 부모가 작다면 부모를 자식과 교체*/
                this.heap()[positionForAdd] = this.heap()[positionForAdd / 2];
                positionForAdd = positionForAdd / 2;
            }
            this.heap()[positionForAdd] = anElement; /*반복문 종료시, 부모가 더 크므로 현재 위치에 원소를 추가*/
            return true;
        }
    }
    public E min() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            return this.heap()[MinPriorityQ.HEAP_ROOT];
        }
    }
    public E removeMin() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            E rootElement = this.heap()[MinPriorityQ.HEAP_ROOT];
            this.setSize(this.size()-1);
            if ( this.size() > 0 ) { /* 삭제후에 적어도 하나의 원소가 남아있다면
                                        heap의 마지막원소를 root에 옮겨 맞는 자리로
                                        찾아 내려가게한다*/
                E lastElement = this.heap()[this.size() + 1];
                int parent = MinPriorityQ.HEAP_ROOT;
                while ((parent * 2) <= this.size()) {
                    // child가 존재한다면, 왼쪽과 오른쪽을 비교해서 더 작은 값을 smallerChild로 한다.
                    int smallerChild = parent * 2;
                    if ((smallerChild < this.size()) &&
                            (this.heap()[smallerChild].compareTo(this.heap()[smallerChild + 1]) > 0)) {
                        smallerChild++;
                    }
                    if (lastElement.compareTo(this.heap()[smallerChild]) <= 0) {
                        break; // 현재 parent 에 last를 위치시키면 되므로 탈출
                    }
                    this.heap()[parent] = this.heap()[smallerChild]; /* parent 가 1일 경우, 이 과정을 통해 가장 작은 값이 root로 오게됨.*/
                    parent = smallerChild;
                }
                this.heap()[parent] = lastElement;
            }
            return rootElement;
        }
    }

}

