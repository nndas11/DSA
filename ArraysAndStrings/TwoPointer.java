package ArraysAndStrings;


// ?. Palindrome check.

public class TwoPointer {
    public static void main(String[] args) {
        String input = "racecar";
        boolean result = isPalindrome(input);
        System.out.println("Is \"" + input + "\" a palindrome? " + result);
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Optional: skip non-alphanumeric chars if checking real-world strings
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
