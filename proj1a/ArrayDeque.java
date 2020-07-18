public class ArrayDeque<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextLast = 0;
        nextFirst = 7;
    }

    private void resize() {
        T[] a = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, a, 0, nextFirst + 1);
        if ((nextFirst + 1) != items.length) {
            System.arraycopy(items, nextFirst + 1, a, items.length + nextFirst + 1, items.length - nextFirst - 1);
        }
        items = a;
        nextFirst = nextFirst + a.length / 2;
    }

    /*
    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[8];
        size = 0;
        nextLast = 7;
        nextLast = 0;

        for (int i = 0; i < other.size(); i++){
            items[i] = (T)other.get(i);
        }
    }
    */

    private int minusOne(int index) {
        if (index - 1 < 0) {
            return items.length - 1;
        }
        return index - 1;
    }

    private int addOne(int index) {
        if (index + 1 > items.length - 1) {
            return 0;
        }
        return index + 1;
    }

    public void addLast(T i) {
        if (nextLast == items.length) {
            nextLast = 0;
        }
        if (nextLast == nextFirst) {
            resize();
        }
        items[nextLast] = i;
        size += 1;
        nextLast += 1;
    }

    public void addFirst(T i) {
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
        if (nextFirst == nextLast) {
            resize();
        }
        items[nextFirst] = i;
        size += 1;
        nextFirst -= 1;
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
        if (nextFirst + 1 >= items.length){
            nextFirst = -1;
        }
        T i = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        size = size - 1;
        return i;
    }

    public T removeLast() {
        if (isEmpty()) {
            System.out.println("Empty");
            return null;
        }
        if (nextLast - 1 < 0){
            nextLast = items.length;
        }
        T i = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast = nextLast - 1;
        size -= 1;
        return i;
    }

    public T get(int index) {
        return items[index];
    }
}
