/**
 * Created by noble on 2017-09-20.
 */
public interface Queue<T> {

    public void reset();

    public int size();

    public boolean isEmpty();
    public boolean isFull();

    public boolean add(T anElement);
    public T remove();
}
