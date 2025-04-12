package Recursion;


//  Time Complexity: O(2^n)
//  Space Complexity: O(n)

public class Fibanocci {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n){
        if(n == 0)
            return 0;
        else if(n ==1)
            return 1;
        else
            return fib(n - 1) + fib(n -2);
    }
}
