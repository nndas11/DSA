package Patterns;


//Given below pattern of license plates (Pattern only, not the actual list of license plates), Find the nth license plate
//All license plates no are of size 5 chars
//Eg, if n is 3, ans is - 00002
//
//        00000
//        00001
//        00002
//        ........
//        ........
//        99999
//        0000A
//0001A
//0002A
//........
//        .........
//        9999A
//0000B
//0001B
//0002B
//.........
//        .........
//        9999B
//0000C
//........
//        ........
//        9999Z
//000AA
//001AA
//.........
//        .........
//        999AA
//000AB
//..........
//        ..........
//        999ZZ
//00AAA
//........
//        ........
//ZZZZZ

public class PatternLicensePlate {
    public static void main(String[] args) {
        System.out.println(patternLicensePlate(100000));
    }

//     1. Breaks the pattern into blocks
//      2. Find which block the nth license plate falls into
//      3. Calculate the exact license plate within that block -> make it 0 indexed
//    4. find the number part and char part
//    5. add and return the license plate

    private static String patternLicensePlate(int n) {
        long[] pow10 = new long[6];
        long [] pow26 = new long[6];
        pow10[0] = 1;
        pow26[0] = 1;

        for(int i=1;i<=5;i++){
            pow10[i] = pow10[i - 1] * 10;
            pow26[i] = pow26[i - 1] * 26;
        }

        long[] S = new long[6]; // number of license plates in each block
        for(int i=0;i<=5;i++){
            S[i] = pow26[i] * pow10[5 - i];
        }

        int block = 0;
        long sum = 0;
        long prevSum = 0;
        for(int i=0;i<=5;i++){
            sum += S[i];
            if(n <= sum){
                block = i;
                break;
            }
            prevSum = sum; // needed to calculate offset within block
        }

        int idx = n - (int)prevSum - 1; // offset within the block
        int numbersCount = 5 - block;
        int charsCount = block;

        int numberPart = idx % (int)pow10[numbersCount];
        int charPart = idx / (int)pow10[numbersCount]; // O -> A, 1 -> B


        String numberStr = helperNumberPart(numberPart, numbersCount);
        String charStr = helperCharPart(charPart, charsCount);

        return numberStr + charStr;
    }

    static String helperNumberPart(int numberPart, int numbersCount){
        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(numberPart);
        int len = numbersCount - s.length();
        for(int i=0;i<numbersCount;i++){
            if(i < len)
                sb.append('0');
            else
                sb.append(s.charAt(i - len));
        }
        return sb.toString();
    }

    static String helperCharPart(int charPart, int k){
        if (k == 0) return "";
        char[] letters = new char[k];
        // Most significant letter first: base-26 with digits 0..25 -> 'A'..'Z'
        for (int pos = k - 1; pos >= 0; pos--) {
            int digit = (int)(charPart % 26);
            letters[pos] = (char)('A' + digit);
            charPart /= 26;
        }
        return new String(letters);
    }
}
