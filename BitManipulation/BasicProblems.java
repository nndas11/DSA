package BitManipulation;



//  Brute force for all the below will be converted to binary and traverse and do check without using any operators.
//  But here we are doing stuff with operators -> so doing internally.
//  Bit operations are slightly faster than doing the usual way.
//  Last Bit of an odd number will be always 1.
//  Odd check is -> n & 1 == 1
//  Divide by 2  -> n >> 1
//  XOR -> a ^ a = 0;
//  XOR -> a ^ b ^ a = b;
//  XOR -> a ^ 0 = a;



//        |  -> will be used to set
//        ^  -> will be used to toggle
//        &  -> will be used to check
//        &~ -> will be used to clear

//  One-Liner:
//        1)	Swapping Two Numbers :
//                  a = (a^b);
//                  b = (a^b);
//                  a = (a^b);
//
//        2)	Check If i’th bit is set or not:
//                  if((Num&(1<<i))!=0){ cout<<”SET”;} else{ cout<<”NOT SET”;}
//
//        3)	Set The i’th bit :
//                  Num=(Num|(1<<i));
//
//        4)	Clear the i’th bit :
//                  Num=(Num&(~(1<<i)));
//
//        5)	Toggle the i’th bit :
//                  Num=(Num^(1<<i));
//
//        6)	Remove the last set bit (RightMost) :
//                  Num=(Num&(Num-1));
//
//        7)	Check power of 2:
//                  if((Num&(Num-1))==0){ cout<<”Power of 2”;} else{ cout<<”Not a power of 2”;}
//
//        8)	Check Number is odd or even :
//                  if((Num&1)==1){cout<<”odd”;} else {cout<<”even”;}
//
//        9)	Divide a number by 2 :
//                  Num=(Num>>1);
//
//        10)	Count number of set bits (C++ user) :
//                  int ans= __builtin_popcount(Num);
//
//        11)	Count number of set bits (Other language) :
//                  int count=0; while(Num!=0){Num=(Num&(Num-1)); count++} return count;

import java.util.Arrays;

public class BasicProblems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        swap(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(countNumberOfSetBits(arr[2]));
        System.out.println(checkNumberOddOrEven(3));
    }

//    Swapping two numbers without 3rd variable.
//    Using XOR Operator: Number of 1s -> odd -> 1 else 0.
//    XOR of a number itself, x ^ x = 0.

//    In Java, primitives like `int` are passed by value when calling a method.
//    You can use a wrapper object or an array. For example:

//    a = a ^ b
//    b = a ^ b = a ^ b ^ b = a
//    a = a ^ b = (a ^ b) ^ a = b
    private static void swap(int[] arr){
        arr[0] = arr[0] ^ arr[1];
        arr[1] = arr[0] ^ arr[1];
        arr[0] = arr[0] ^ arr[1];
    }


//    Brute Force:
//    Convert number to binary and traverse from back i times and check the bit.
//    Better way: either left shift and place a 1 right below the position
//    Or right shift and place the bit to check at the end.
    private static boolean checkIthBitSetOrNot(int num , int i){
        if((num & (1 << i)) != 0)
            return true;
        else
            return false;

//        Using right shift operator
//        if( ((num >> i) & 1) == 1)    return true
//        else  return false;
    }


//    We want to make ith bit as 1.
//    take a 1 and place right below the position and do OR to set it.
//    While using binary operator, the conversion to binary and all will be done internally, no need to worry.
    private static int setIthBit(int num, int i){
        num = num | (1 << i);
        return num;
    }


//    We want to make the ith bit 0. -> so will be using AND operator.
//    so left shift to that position and also don't need to change anything else
//    so left shift 0 to i and then negate.
    private static int clearIthBit(int num, int i){
        num = (num & (~(1 << i)) );
        return num;
    }


//    change 0 to 1 and 1 to 0.
    private static int toggleIthBit(int num, int i){
        num = num ^ (1 << i);
        return num;
    }

//    (right-most bit)
//    PATTERN : N to N - 1 -> in the binary -> the right most bit becomes flipped and all other bits after becomes 1.
    private static int removeLastSetBit(int num){
        num = num & (num - 1);
        return num;
    }

    private static boolean checkPowerOfTwo(int num){
        if(num <= 0)    return false;
        return (num & (num - 1)) == 0;
    }


//    Only Brute Force available
//    Convert to binary, while doing keep count;
    private static int countNumberOfSetBits(int num){
        int count = 0;

        while (num > 0){
//            int rem = num % 2;
//            if(rem == 1)    count++;
//            num = num / 2;

            if((num & 1) == 1)  count++;
            num = num >> 1;
        }

        return count;
    }

    private static int countNumberOfSetBits2(int num){
        int count = 0;
        while(num != 0){
            num = (num & (num - 1));
            count++;
        }
        return count;
    }

    private static String checkNumberOddOrEven(int num){
        if((num & 1) == 1)
            return "Odd";
        return "Even";
    }


}
