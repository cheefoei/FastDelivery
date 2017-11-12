package adt;

/**
 *
 * @author cheefoei's
 */
public interface ListInterface<T> {

    public boolean add(T entry);

    public boolean add(int index, T entry);

    public T get(int index);

    public boolean remove(T entry);

    public boolean remove(int index);

    public boolean removeAll();

    public boolean isEmpty();

    public boolean isContain(T entry);

    public int size();

    public T[] toArray();
    
    public void sortByAplhabet();
}
