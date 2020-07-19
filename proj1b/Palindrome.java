public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 0) {
            return false;
        }
        int j = word.length() - 1;
        for (int i = 0; i <= word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            j -= 1;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int j = word.length() - 1;
        for (int i = 0; i <= word.length() / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
            j++;
        }
        return true;
    }
}
