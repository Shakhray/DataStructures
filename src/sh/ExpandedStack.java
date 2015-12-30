package sh;

/**
 * @Author Sherhan
 */
public class ExpandedStack<T> extends Stack<T> {
    private static final int NOT_FOUND = -1;

    public T get(int index) {
        if (index >= 0) {
            for (T t : this) {
                if (index == 0) {
                    return t;
                } else {
                    index--;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean contains(Object obj) {
        for (T t : this) {
            if (objectsEquals(t, obj))
                return true;
        }
        return false;
    }

    public int indexOf(Object obj) {
        int indexOf = NOT_FOUND;
        for (T t : this) {
            indexOf++;
            if (objectsEquals(t, obj))
                return indexOf;
        }
        return NOT_FOUND;
    }

    private boolean objectsEquals(T t, Object obj) {
        return (t == null && obj == null) || (t != null && t.equals(obj));
    }

    public Object[] toArray() {
        Object[] array = new Object[size()];
        int index = 0;
        for (T t : this)
            array[index++] = t;
        return array;
    }
}
