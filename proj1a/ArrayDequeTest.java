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
    public void addfirsttest(){
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(12);
        input.addLast(145);
        input.addLast(352);
        input.addLast(333);
        input.removeFirst();
        input.addFirst(134);
        input.removeLast();
        input.addFirst(45);
        input.removeFirst();
        input.addFirst(11);

        input.printDeque();
    }
}
