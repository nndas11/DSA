package BitManipulation;



//  Integers are stored as 32 bit in the computer -> converting the decimal to binary.
//  The left most bit(31st bit) is used to store the sign  -> + or -.
//  +ve -> 0
//  -ve -> 1
//  Largest value we can store in integer = 2^31 - 1.
//  Smallest value we can store in integer = -2^31

//  How does computer stores negative numbers?
//  Converts to 2s complement stores.
//  Eg: -13
//      Take the binary: 0 0 0 .......... 1 1 0 1
//      1s complement  : 1 1 1 .......... 0 0 1 0
//      Add + 1 -> for getting 2s complement : 1 1 1 ......... 0 0 1 1
//      Here the last bit(left-most) will be 1 -> as it a negative number.

//  When finding 1’s or 2’s complement, the signed (leftmost) bit is also flipped—just like every other bit.

//  ----------- OPERATORS -------------

//  AND, OR, XOR, SHIFT, NOT

//  AND -> &
//  All true -> true
//  Any 1 false -> false

//  OR -> |
//  Any 1 true -> true
//  All False -> false

//  XOR -> ^
//  Number of 1s -> odd -> 1.
//  Number of 1s -> even -> 0.

//  SHIFT
//  RIGHT SHIFT -> >>
//  Bit on the right goes
//  x >> k = x/2^k

//  LEFT SHIFT -> <<
//  Bits move left.
//  Leftmost Bit goes.
//  x << k = x * 2^k
//  we cannot left shift the largest integer -> goes overflow.

//  NOT -> ~
//  1.  Flip number -> signed bit also flipped
//  2.  check -ve -> looking at signed bit
//      1. if negative -> store 2s complement -> while now flipping for 1s complement(signed bit not taken).
//      2. else -> stop.

//  While doing operation with negative number -> always first convert to 2s complement and do operations.
//  As computer stores number in 2s complement.


public class Basics {
    public static void main(String[] args) {
        int decimal = 13;
        String binary = "1101";
        System.out.println(decimalToBinary(decimal));
        System.out.println(binaryToDecimal(binary));
    }

    private static String decimalToBinary(int decimal){
        StringBuilder sb = new StringBuilder();

        if (decimal == 0)   return "0";

        while (decimal > 0){
            int rem = decimal % 2;
            sb.append(rem);
            decimal = decimal / 2;
        }

        return sb.reverse().toString();
    }

    private static int binaryToDecimal(String binary){
        int n = binary.length();
        int decimal = 0;

        int j = 0;
        for (int i = n - 1; i>=0 ;i--){

//            You’re doing `(int) binary.charAt(i)`, which gives the ASCII value of the character (‘0’ → 48, ‘1’ → 49),
//            not the digit itself (0 or 1).
//            You need to convert the character to an integer by: `binary.charAt(i) - '0'`


            decimal += (int) Math.pow(2, j) *  (binary.charAt(i) - '0');
            j++;
        }

        return decimal;
    }
}
