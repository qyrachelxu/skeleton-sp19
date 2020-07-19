public class LinkedListDeque<T> implements Deque<T> {

    private class TNode {
        private T item;
        private TNode next;
        private TNode prev;

        public TNode(TNode p, T i, TNode n) {
            item = i;
            next = n;
            prev = p;
        }

        private T getRecursive(int index) {
            TNode p = this;
            if (index == 0) {
                return p.item;
            } else {
                return p.next.getRecursive(index - 1);
            }
        }
    }

    private TNode sentinel;
    private int size;

    /* Creates an empty linked list deque.*/
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(T item) {
        if (size == 0) {
            TNode p = new TNode(sentinel, item, sentinel);
            sentinel.next = p;
            sentinel.prev = p;
        } else {
            TNode p = new TNode(sentinel, item, sentinel.next);
            sentinel.next.prev = p;
            sentinel.next = p;
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == 0) {
            TNode p = new TNode(sentinel, item, sentinel);
            sentinel.next = p;
            sentinel.prev = p;
        } else {
            TNode p = new TNode(sentinel.prev, item, sentinel);
            sentinel.prev.next = p;
            sentinel.prev = p;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        TNode p = sentinel.next;
        while (p != sentinel) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        TNode p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        size -= 1;
        return p.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        TNode p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        size -= 1;
        return p.item;
    }

    @Override
    public T get(int index) {
        TNode p = sentinel.next;
        int i = 0;
        while (p != sentinel) {
            if (i == index) {
                return p.item;
            }
            p = p.next;
            i = i + 1;
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        if (size() == 0 || index >= size()) {
            return null;
        }
        return sentinel.next.getRecursive(index);
    }
}