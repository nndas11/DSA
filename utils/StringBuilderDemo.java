package utils;


//  What is StringBuilder?
//  A mutable sequence of characters.
//  Unlike String, it can be modified without creating a new object each time.
//  Faster than StringBuffer in single-threaded applications because it is not synchronized.

//  When to Use It?
//  When you need to build or modify strings repeatedly (e.g., in loops).
//  When working in single-threaded code.
//  When performance is critical and you don’t need thread-safety.


public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" World");                   // Hello World
        sb.insert(5, ",");                     // Hello, World
        sb.replace(7, 12, "Java");             // Hello, Java
        sb.delete(5, 6);                       // Hello Java
        sb.reverse();                          // avaJ olleH

        System.out.println(sb.toString());


        String[] words = new String[]{"hallo", "world"};

        String result = "";
        for (String word : words) {
            result += word;  // BAD: creates new String object every time
        }

        StringBuilder sb1 = new StringBuilder();
        for (String word : words) {
            sb1.append(word);
        }
        System.out.println(sb1.toString());
    }
}
