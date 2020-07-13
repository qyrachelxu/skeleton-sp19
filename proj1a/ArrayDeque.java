public class ArrayDeque<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextLast = 1;
        nextFirst = 0;
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
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
        if (index - 1 < 0){
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
        if (size == items.length){
            resize(size * 2);
        }
        items[nextLast] = i;
        size += 1;
        nextLast = addOne(nextLast);
    }

    public void addFirst(T i) {
        if (size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = i;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public T removeFirst() {
        T i = items[addOne(nextFirst)];
        items[addOne(nextFirst)] = null;
        size -= 1;
        if (4 * size < items.length) {
            resize(4 * size);
        }
        return i;
    }

    public T removeLast() {
        T i = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size -= 1;
        if (4 * size < items.length) {
            resize(4 * size);
        }
        return i;
    }

    public T get(int index){
        int i = addOne(nextFirst);
        for (int n = 0; n != index; n++){
            i = addOne(nextFirst);
        }
        return items[i];
    }
}
