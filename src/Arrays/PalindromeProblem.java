package Arrays;

public class PalindromeProblem {

    public static void main(String[] args) {
        char[] word1 = "anna".toCharArray();
        System.out.println(checkPalindrome(word1));
    }

    private static boolean checkPalindrome(char[] word1) {
        //it has O(N) linear running time complexity (O(N/2) is the same as O(N))
        for (int i = 0; i < word1.length/2; i++) {
            if (word1[i] != word1[word1.length-i-1]) {
                return false;
            }
        }
        return true;
    }
}
