package BinarySearch.TwoDArray;

public class RowWithMaximumNumberOf1s {
    public static void main(String[] args) {
        System.out.println(rowWithMaximum1s(new int[][]{
                {1,1,1},
                {0,0,1},
                {0,0,0}
        }, 3, 3
        ));
    }

    public static int rowWithMaximum1s(int[][] matrix, int n, int m) {
        int ans = -1;
        int maxCount = 0;

        for(int i=0;i<n;i++){
            int l = 0;
            int r = m - 1;

            while(l <= r){
                int mid = l + (r - l)/2;

                if(matrix[i][mid] == 1){
                    int count = m - mid;
                    if(count > maxCount){
                        maxCount = count;
                        ans = i;
                    }
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }


        return ans;
    }
}
