import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackImpl implements stac{

    @Override
    public  int[] nextGreaterElement(int[] arr) {

        int[] output = new int[arr.length];
        Arrays.fill(output, -1);

        //Stack declaration
        Stack<Integer> st = new Stack<>();

        //Traverse an array
        for (int i = 0; i < 2* output.length; i++) {
            int elementTobeChecked=arr[i% output.length];
            while (!st.isEmpty() && arr[st.peek()] < elementTobeChecked) {
                output[st.pop()] = elementTobeChecked;
            }
            if(i < output.length) {
                //pushing till i is in range
                st.push(i); //playing with indexes
            }
        }

        return output;
    }

    public int[] detectTemperature(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] output = new int[arr.length];
        if(arr.length==0) return output;

       for(int i=arr.length-1; i>=0; i++){
           while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
               st.pop();  //we will get the last element
               //we will place
           }
           if(!st.isEmpty() && arr[i]<arr[st.peek()]){
               //we will check if the element is hotter then put that element to the result
               //by calculating the distance
               int distance=st.peek()-i;
               output[i]=distance;
           }
           st.push(i);
       }
       return output;
    }

    public static void main(String[] args) {
        stac st = new StackImpl();
        int arr[]= {1,2,3,4,4,3};
        int n[]=st.nextGreaterElement(arr);
        for(int i=0; i<n.length; i++){
            System.out.print(n[i]+" ");
        }

    }
}
