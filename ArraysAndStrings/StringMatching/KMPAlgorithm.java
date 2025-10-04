package ArraysAndStrings.StringMatching;


//  KMP Algorithm -> Builds a Longest Prefix Suffix (LPS) array for the pattern to skip redundant comparisons.
//  We need to avoid unnecessary comparisons in the text when a mismatch occurs after some matches.
//  TC: O(n + m) -> n is the length of the text and m is the length of the pattern.
//  SC: O(m) -> for LPS array.


//  STEP:
//  1. Build the LPS array for the pattern. -> we want the proper prefix which is also a suffix. -> proper prefix means it cant be equal to the string itself.
//  2. Use the LPS array to search the pattern in the text.
//  3. If a mismatch occurs after some matches, use the LPS array to skip unnecessary comparisons in the text.
//  4. If a match is found, return the starting index of the match in the text.
//  5. If no match is found, return -1.


//  When mismatch occurs after j matches, we do not need to match the first j characters again.
//  i never goes back in


//  IMPORTANT:
//          When mismatch occurs, we move j to lps[j-1].
//          In KMP LPS, the same character can be part of both prefix and suffix.

public class KMPAlgorithm {
    public static void main(String[] args) {

    }

    private static boolean kmpAlgorithm(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = buildLPS(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else {
                if(j != 0){
                    j = lps[j - 1];
                }else
                    i++;

            }

            if(j == m)
                return true;
        }
       return false;
    }

    private static int[] buildLPS(String pattern){
       int m = pattern.length();
       int[] lps = new int[m];

        int i = 1; // we start from index 1 because lps[0] is always 0
        int len = 0; // length of the previous longest prefix suffix

        while (i < m){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else {
                if(len != 0){
                    len = lps[len - 1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

       return lps;
    }
}
