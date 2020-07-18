import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addlasttest() {
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(1);
        input.addLast(2);
        input.addLast(3);

        input.printDeque();
    }

    @Test
    public void addfirsttest() {
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(0);
        input.addFirst(1);
        input.addLast(2);
        input.addFirst(3);
        input.addFirst(4);
        input.removeFirst();
        input.addFirst(6);
        input.removeFirst();
        input.removeFirst();
        input.removeLast();
        input.removeFirst();
        input.addFirst(2);

        input.printDeque();
    }
}
