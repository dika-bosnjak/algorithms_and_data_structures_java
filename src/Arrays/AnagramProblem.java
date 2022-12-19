package Arrays;

import java.util.Arrays;


public class AnagramProblem {

    public static void main(String[] args) {
        char[] word1 = "restful".toCharArray();
        char[] word2 = "fluster".toCharArray();
        System.out.println(checkAnagaram(word1, word2));
    }

    public static boolean checkAnagaram(char[] word1, char[] word2) {
        if (word1.length != word2.length) {
            return false;
        }

        //sort the letters of the strings
        //O(NlogN) this is the bottleneck of the algorithm
        Arrays.sort(word1);
        Arrays.sort(word2);

        //compare the values on specific indexes, O(N), but the overall running time is O(NlogN) + O(N) = O(NlogN)
        for(int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) {
                return false;
            }
        }

        return true;
    }
}
