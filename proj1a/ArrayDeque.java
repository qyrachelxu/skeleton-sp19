public class ArrayDeque<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private double Ufactor;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextLast = 0;
        nextFirst = 7;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(T i) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[size] = i;
        size += 1;
        nextLast += 1;
    }

    public void addFirst(T i) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        T[] a = (T[]) new Object[items.length + 1];
        System.arraycopy(items, 0, a, 1, size);
        items = a;
        items[0] = i;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("Empty");
            return null;
        }
        T i = items[0];
        items[0] = null;
        size = size - 1;
        T[] a = (T[]) new Object[items.length];
        System.arraycopy(items, 1, a,0, size);
        items = a;
        if (size * 1.0 / items.length < 0.25) {
            resize(size);
        }
        return i;
    }

    public T removeLast() {
        if (isEmpty()) {
            System.out.println("Empty");
            return null;
        }
        T i = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        if (size / items.length < 0.25) {
            resize(size);
        }
        return i;
    }

    public T get(int index) {
        return items[index];
    }
}
