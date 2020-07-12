public class ArrayDeque<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextLast = 7;
        nextLast = 0;
    }

    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[8];
        size = 0;
        nextLast = 7;
        nextLast = 0;

        for (int i = 0; i < other.size(); i++){
            items[i] = (T)other.get(i);
        }
    }

    public int minusOne(int index){
        if (index - 1 < 0){
            return 7;
        }
        return index - 1;
    }

    public int addOne(int index){
        if (index + 1 > 7){
            return 0;
        }
        return index + 1;
    }

    public void addLast(T i){
        items[nextLast] = i;
        size += 1;
        nextLast = addOne(nextLast);
    }

    public void addFirst(T i){
        items[nextFirst] = i;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    public boolean isEmpty(){
        for (int i = 0; i < items.length; i++){
            if (items[i] != null){
                return false;
            }
        }
        return true;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < items.length; i++){
            System.out.println(items[i]);
        }
    }

    public T removeFirst(){
        if (items[addOne(nextFirst)] == null){
            return null;
        }
        else {
            T i = items[addOne(nextFirst)];
            items[addOne(nextFirst)] = null;
            nextFirst =  addOne(nextFirst);
            return i;
        }
    }

    public T removeLast(){
        if (items[minusOne(nextLast)] == null){
            return null;
        }
        else {
            T i = items[minusOne(nextLast)];
            items[minusOne(nextLast)] = null;
            nextLast = minusOne(nextLast);
            return i;
        }
    }

    public T get(int index){
        if (items[index] == null){
            return null;
        }
        else {
            return items[index];
        }
    }

}
