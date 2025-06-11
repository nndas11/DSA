package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        System.out.println(nextPermutation(3, 3));
    }

    public static String nextPermutation(int n, int k){
        List<Integer> numbers = new ArrayList();
        int fact = 1;
        StringBuilder ans = new StringBuilder();

        k = k - 1;

        for(int i=1;i<=n;i++){
            numbers.add(i);
            fact *= i;
        }


        while(true){
            fact = fact/numbers.size();
            ans.append(numbers.get(k / fact));
            numbers.remove(k/fact);

            if(numbers.isEmpty())
                break;

            k = k % fact;
        }
        return ans.toString();
    }
}
