package Recursion;


//  Time Complexity: O(2^n)
//  Space Complexity: O(n)

public class Fibanocci {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n){
        if(n <= 1)
            return n;
        return fib(n - 1) + fib(n -2);
    }
}
