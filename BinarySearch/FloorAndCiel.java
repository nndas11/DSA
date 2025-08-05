package BinarySearch;

public class FloorAndCiel {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30 , 40};
        int x = 25;
        System.out.println(floor(arr, x));
        System.out.println(ciel(arr, x));
    }

//    Floor -> the largest number in array[index] <= x.
    private static int floor(int[] arr, int x){
        int ans = -1;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] <= x){
                ans = arr[mid];
                l = mid + 1;
            }else
                r = mid - 1;
        }

        return ans;

    }

//    Ciel -> the smallest number in array[index] >= x.
//    Same as lower-bound.
    private static int ciel(int[] arr, int x){
        int ans = -1;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] >= x){
                ans = arr[mid];
                r = mid - 1;
            }else
                l = mid + 1;
        }

        return ans;
    }
}
