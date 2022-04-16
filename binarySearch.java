import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    static int upperBoundCount(int[] arr, int n, int ele){
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==ele && mid+1<n && arr[mid+1]!=ele){
                return mid+1;
            }
            else if(arr[mid]>ele){
                end=mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return end+1;
    }
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        // add your code here
        //   Collections.sort(arr1);
        Arrays.sort(arr2);

        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0; i<m; i++){
            int ele = arr1[i];
            a.add(upperBoundCount(arr2, n, ele));
        }
        return a;
    }
    public static void main(String[] args) {
        final ArrayList<Integer> integers = countEleLessThanOrEqual(new int[]{1, 2, 3, 4, 7, 9}, new int[]{0, 1, 2, 1, 1, 4}, 6, 6);
        System.out.println(integers);
    }
}
