import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class wipro implements WTurbo{
    public void leadersInArray(){
//        For example int the array {16, 19, 4, 3, 8, 3}, leaders are 19, 8 and 3?
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
//        O(N) approach space
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i=1; i<n; i++){
            if(st.peek()>arr[i]){
                st.push(arr[i]);
                continue;
            }
                while(!st.isEmpty() && st.peek()<arr[i])
                {
                    st.pop();
                }
            st.push(arr[i]);
        }
        ArrayList<Integer> a = new ArrayList<>();
        while (!st.isEmpty()){
            a.add(st.pop());
        }
        Collections.sort(a,Collections.reverseOrder());
        System.out.println(a);

    }

    public int maxDifferenceWithSmallerFirst(){
//        7
//        2 3 10 6 4 8 1
//        6
//        7 9 5 6 3 2
        //ON ON
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        Stack<Point> st = new Stack<>();
        st.push(new Point(arr[0],Integer.MAX_VALUE));
        int smallest=arr[0];
//        int min=Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            if(arr[i]>smallest){
                st.push(new Point(arr[i],smallest));
            }
            else{
                smallest=arr[i];
            }
        }
        int max=0;
        while(!st.isEmpty()){
            max=Integer.max(st.peek().x-st.peek().y,max);
            st.pop();
        }
        return max;
//        O(n^2)  O(1)
//        int max_diff = arr[1] - arr[0];
//        int i, j;
//        for (i = 0; i < arr_size; i++)
//        {
//            for (j = i + 1; j < arr_size; j++) { if (arr[j] - arr[i] > max_diff)
//                max_diff = arr[j] - arr[i];
//            }
//        }
//        return max_diff;
    }

    public void longestPrefixAlsoSuffix(){
        int t = new Scanner(System.in).nextInt();
        while(t-->0) {
             String a = new Scanner(System.in).next();
             int len=computeLPSandReturn(a);
             int n=a.length();
             //we dont need proper and non overlapping length then min with n/2 else as it is
             System.out.println(len);
            }

    }

    public int computeLPSandReturn(String a){
        int []lps = new int[a.length()];
        int i=1;
        int m=a.length();
        int len=0;
        while(i<m){
            if(a.charAt(len)==a.charAt(i)){
                lps[i] = len+1;
                len++;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[m-1];
    }

//    static boolean isNumber(char a){
//
//    }

    public int Evaluate_BoolExp(){
        String a = new Scanner(System.in).next();
        int res=-1;
        int n=a.length();
        for(int i=2; i<=n; i+=2){
            if(res==-1) {
                //we need at least previous 3 characters
                if ( a.charAt(i - 1) == 'A') {
                    res = Integer.parseInt(String.valueOf(i - 2)) & Integer.parseInt(String.valueOf(a.charAt(i)));
                } else if ( a.charAt(i - 1) == 'B') {
                    res = Integer.parseInt(String.valueOf(i - 2)) | Integer.parseInt(String.valueOf(a.charAt(i)));
                } else if ( a.charAt(i - 1) == 'C') {
                    res = Integer.parseInt(String.valueOf(i - 2)) ^ Integer.parseInt(String.valueOf(a.charAt(i)));
                }
            }
            else{
                if(a.charAt(i-1)=='A'){
                    res=res& Integer.parseInt(String.valueOf(a.charAt(i)));
                }
                else if(a.charAt(i-1)=='B'){
                    res=res| Integer.parseInt(String.valueOf(a.charAt(i)));
                }
                else if(a.charAt(i-1)=='C'){
                    res=res^ Integer.parseInt(String.valueOf(i));
                }
            }
        }
        return res;
    }

    public void CompressString(){
        String a = new Scanner(System.in).next();
        int n=a.length();
        int cnt=1;
        for(int i=1; i<n; i++){
            if(a.charAt(i-1)==a.charAt(i)){
                cnt++;
            }
            else{
                if(cnt<2) {
                    System.out.print(a.charAt(i-1));
                    continue;
                }
                System.out.print(a.charAt(i-1)+""+cnt);
                cnt=1;
            }

        }
        if(cnt==1) {
            System.out.print(a.charAt(n-1));
            return;
        }
        System.out.print(a.charAt(n-1)+""+cnt);
        System.out.println();
    }

    public void makePalindrome(){
        String a = new Scanner(System.in).next();
        int n=a.length();
        if(n==1){
            System.out.println(a);
            return;
        }
        int i=-1;
        while(a.charAt(++i)!=a.charAt(n-1));
        System.out.println(new StringQuestions().reverse(a.substring(0,i)));
    }

    public void sumOfOddFactors(){
        int n=new Scanner(System.in).nextInt();
        int sum=0;
        for(int i=1; i<=n; i++){
            if(n%i==0 && i%2==1){
//                System.out.print(i+" ");
                sum+=i;
            }
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
//        new wipro().leadersInArray();
//        System.out.println(new wipro().maxDifferenceWithSmallerFirst());
//        System.out.println(new wipro().Evaluate_BoolExp());
//        new wipro().CompressString();
//        new wipro().makePalindrome();
        new wipro().sumOfOddFactors();
    }
}
