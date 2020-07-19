public class OffByN implements CharacterComparator {

    int i;

    public void OffByN(int n) {
        this.i = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == i || y - x == i) {
            return true;
        }
        return false;
    }
}
