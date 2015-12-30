package sh;

import java.util.Iterator;

/**
 * @author Sherhan
 */
public class Stack<T> implements Iterable<T>, Cloneable {
    private static final boolean POP = true;
    private static final boolean PEEK = false;
    private Node head = null;

    public void push(T t) {
        head = new Node(t, head);
    }

    public T peek() {
        return getValueFor(PEEK);
    }

    public T pop() {
        return getValueFor(POP);
    }

    private T getValueFor(boolean isPop) {
        T value = null;
        if (!isEmpty()) {
            value = head.value;
            if (isPop) head = head.next;
        }
        return value;
    }

    public int size() {
        int size = 0;
        for (T ignored : this)
            size++;
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node headForIter;

            {
                try {
                    if (!isEmpty()) headForIter = head.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public boolean hasNext() {
                return headForIter != null;
            }

            @Override
            public T next() {
                return popForIter();
            }

            private T popForIter() {
                T value = null;
                if (headForIter != null) {
                    value = headForIter.value;
                    headForIter = headForIter.next;
                }
                return value;
            }
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stack<T> clone() throws CloneNotSupportedException {
        Stack<T> clone = (Stack<T>) super.clone();
        clone.head = head.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "[" + (isEmpty() ? "" : head.toString()) + "]";
    }

    protected class Node implements Cloneable {
        T value = null;
        Node next = null;

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        boolean hasNext() {
            return next != null;
        }

        @Override
        public int hashCode() {
            int curHash = value.getClass().equals(String.class)
                    ? value.hashCode() * 12
                    : value.toString().hashCode() * 13;
            return curHash + (hasNext() ? next.hashCode() : 0);
        }

        @Override
        public boolean equals(Object otherNode) {
            return otherNode != null && otherNode.getClass().equals(Node.class)
                    && hashCode() == otherNode.hashCode();
        }

        @Override
        @SuppressWarnings("unchecked")
        public Node clone() throws CloneNotSupportedException {
            Node clone = (Node) super.clone();
            if (hasNext()) clone.next = next.clone();
            return clone;
        }

        @Override
        public String toString() {
            return value.toString() + (hasNext() ? ", " + next.toString() : "");
        }
    }
}