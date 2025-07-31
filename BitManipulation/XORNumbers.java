package BitManipulation;

//  Given an integer n, find the XOR of all numbers from 1 to n?

//  Brute Force doing simple XOR of all using for-loop.


//  PATTERN-ORIENTED QUESTION.
//  Need to know the pattern before interview.

public class XORNumbers {
    public static void main(String[] args) {
        System.out.println(xORNumbers(2));
    }

//    SIMPLE PATTERN-ORIENTED QUESTION.
//    TC: O(1)
//    SC: O(1)
    private static int xORNumbers(int n){
        if(n % 4 == 1)  return 1;
        if(n % 4 == 2)  return n + 1;
        if(n % 4 == 3)  return 0;
        return n;
    }

//    Follow-up Question:
//    Instead of finding from 1 to n range, you are given range: [L, R]. Need to find the XOR of all elements from L to R?

//    TC: O(1)
//    SC: O(1)
    private static int xORNumbersRange(int l, int r){
//        property of XOR:
//        a ^ a = 0
//        a ^ 0 = a
        return xORNumbers(l - 1) ^ xORNumbers(r);
    }
}
