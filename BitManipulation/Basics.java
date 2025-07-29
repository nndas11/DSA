package BitManipulation;

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
