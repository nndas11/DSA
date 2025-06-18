package DynamicProgramming;

//  n days.
//  each day can do 1 of 3 activities with each activity has different points on each day.
//  same activity cannot be done on consecutive days.
//  find the maximum points ninja can earn.


//  Here 2 dependent variable -> so we need to use 2-d array.

//  TC: O(n * 4) * 3 = O(n * 12)
//  SC: O(N * 4) + O(n)(recursion stack space)

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {

        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        System.out.println("Maximum points he can achieve is : " + ninjaTraining(points, 3));


    }

    public static int ninjaTraining(int[][] points, int n){

        int[][] dp = new int[n][4];
        for (int[] row: dp){
            Arrays.fill(row, -1);
        }

        return ninjaTrainingMemoization(n - 1, 3, points, dp);
    }

    public static int ninjaTrainingMemoization(int day, int lastTask, int[][] points, int[][] dp){

        if(day == 0){
            int maxPoints = 0;
            for(int i = 0; i < 3;i++){
                if(i != lastTask){
                    maxPoints = Math.max(maxPoints, points[day][i]);
                }
            }
            return maxPoints;
        }

        if(dp[day][lastTask] != -1){
            return dp[day][lastTask];
        }


        int maxPoints = 0;

        for(int i = 0;i < 3;i++){
            if(i != lastTask){
                int point = points[day][i] + ninjaTrainingMemoization(day - 1, i, points, dp);
                maxPoints = Math.max(maxPoints, point);
            }
        }

        dp[day][lastTask] = maxPoints;
        return dp[day][lastTask];
    }

//    So converting 2-D DP problem into tabulation(bottom-up approach) method.
//    Here the base case day == 0, can occur when last = 0, 1, 2, 3.
//    So we have to fill all these 4 in the dp-array.

//    TC: O(n * 4 * 3)
//    SC: O(n * 4) -> improved from above by removing the recursion stack space.

    public static int ninjaTrainingTabulation(int[][] points, int[][] dp, int n){

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day = 1; day<n;day++){
           for (int last = 0; last < 4;last++){

               // Initialize the maximum points for the current day and last activity
               // Anyway we are calculating the dp[day][last] so just use that instead of maxPoints variable if okay with you.
               dp[day][last] = 0;

               // Consider each possible task for the current day
               for(int task = 0;task < 3;task++){
                   if(task != last){ // Ensure that the current task is different from the last

                       // Calculate the points for the current activity and add it to the maximum points from the previous day
                       int point = points[day][task] + dp[day - 1][task];

                       // Update the maximum points for the current day and last activity
                       dp[day][last] = Math.max(dp[day][last], point);
                   }
               }

           }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n-1][3];
    }




//    We can optimise this further and remove all the space in the above cases.
//    How can we know that above this can be more space optimised?
//    So here we are suing "dp[day - 1][task]" -> so "day - 1" is a previous state -> so here is where we can optimise our algorithm for space.

    public static int ninjaTrainingSpaceOptimised(int[][] points, int n){
        int c1 = points[0][0], c2 = points[0][1], c3 = points[0][2];

        for(int i = 1; i < points.length; i++) {
            int n1 = Math.max(c2, c3) + points[i][0];
            int n2 = Math.max(c1, c3) + points[i][1];
            int n3 = Math.max(c1, c2) + points[i][2];

            c1 = n1;
            c2 = n2;
            c3 = n3;
        }

        return Math.max(c1, Math.max(c3, c2));
    }
}
