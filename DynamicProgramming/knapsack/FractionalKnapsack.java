package DynamicProgramming.knapsack;

//  COMES UNDER GREEDY ALGORITHM.

//  Given -> n items -> each has a value and weight.
//  [[value, weight]] -> items: array
//  Total weight of the bag -> W.
//  Maximise the total value.

//  How is it different from other knapsack problems?
//  As the name suggests, here we can take fraction of each item if needed to maximise the value.

import java.util.Arrays;


public class FractionalKnapsack {
    public static void main(String[] args) {
        int[][] items = {
                {100, 20},
                {60, 10},
                {100, 50},
                {200, 50}
        };

        System.out.println(fractionalKnapsack(items, 90));
    }

    //    TC: O(n logn) + O(n).
    //    SC: O(1).
    public static double fractionalKnapsack(int[][] items, int W){

//       This is where the greedy algorithm comes -> as we are sorting to get maximum here(which is the question).
        Arrays.sort(items, (a, b) -> Integer.compare(b[0]/b[1], a[0]/a[1]));
        int i = 0;
        int n = items.length;

//        using double -> as we are taking fractions.
        double totalValue = 0;

        while (i < n && W > 0){
            if(items[i][1] <= W){
                totalValue += items[i][0];
                W -= items[i][1];
            }else {
//                fractional case
                totalValue += (((double) items[i][0] /items[i][1]) * W);
                break;
            }
            i++;
        }

        return totalValue;
    }
}
