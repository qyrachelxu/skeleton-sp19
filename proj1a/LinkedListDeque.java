import java.awt.desktop.SystemSleepEvent;

public class LinkedListDeque<T> {

    public class TNode {
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(TNode p, T i, TNode n){
            item = i;
            next = n;
            prev = p;
        }
    }

    private TNode sentinel;
    private int size;

    /* Creates an empty linked list deque.*/
    public LinkedListDeque(){
        sentinel = new TNode(null, null, null);
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque(LinkedListDeque other){
        sentinel = new TNode(null, null, null);
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        for (int i = 0; i < other.size(); i++){
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T item){
        if (sentinel.next == sentinel){
            TNode p = new TNode(sentinel, item, sentinel);
            sentinel.next = p;
            sentinel.prev = p;
        }
        else{
            TNode p = new TNode(sentinel, item, sentinel.next);
            sentinel.next.prev = p;
            sentinel.next = p;
        }
        size += 1;
    }

    public void addLast(T item){
        if (sentinel.prev == sentinel){
            TNode p = new TNode(sentinel, item, sentinel);
            sentinel.next = p;
            sentinel.prev = p;
        }
        TNode p = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public boolean isEmpty(){
        if (sentinel.next == sentinel){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        TNode p = sentinel.next;
        while (p != sentinel){
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst(){
        if (sentinel.next == sentinel){
            return null;
        }
        TNode p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        return p.item;
    }

    public T removeLast(){
        if (sentinel.prev == sentinel){
            return null;
        }
        TNode p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        return p.item;
    }

    public  T get(int index){
        TNode p = sentinel.next;
        int i = 0;
        while (p != sentinel){
            if (i == index){
                return p.item;
            }
            i = i + 1;
        }
        return null;
    }

    public T getRecurHelp(int index){
        TNode p = sentinel;
        int i = -1;
        while (i != index){
            if (p == sentinel){
                return null;
            }
            p = p.next;
            i += 1;
        }
        if (p == sentinel){
            return null;
        }
        return p.item;
    }

    public T getRecursive(int index){
        TNode p = sentinel.next;
        int i = 0;
        if (i == index){
            return getRecurHelp(i);
        }
        return getRecursive(i + 1);
    }

}
