import java.util.Scanner;
import java.util.stream.IntStream;

public class infosysQ implements infosys
{
    //  https://prepinsta.com/infosys-sp-and-dse/coding-questions/


//    private static int countUgliness(int textPtr, int[] dp, int a, int b, int cash, int a_way, int b_way, char[] str,int valA,int valB) {
//        if (dp[textPtr] != -1)
//            return dp[textPtr];
//        if (textPtr == 0 || cash <= 0)
//            return 1;
//        //we have two options either flip or swap but  if the character is 0 then we dont swap if they are both zero
//        //for(int i=textPtr; i>0; i--){
//        //for every character we check cost
//        for(int j=textPtr-1; j>=0; j--)
//            {
//                //for swap we check if we are finding minimum
//                //we dont want both to be 0 and we swap only if next char is 0
//                if(str[j]!=str[textPtr] && (str[textPtr]=='0' && str[j]=='1'))
//                {
//                    //we swap the characters
//                    char temp = str[j];
//                    str[j] = str[textPtr];
//                    str[textPtr] = temp;
//                    // we reduce the cost
//                    cash -= a;
//                    valA = Integer.parseInt(new String(str),2);
//                    a_way += countUgliness(textPtr-1,dp,a,b,cash,a_way,b_way, str,valA,valB);
//                }
//            }
//            //we check the minimum with a cost and b cost
//            if(str[textPtr] != 0){
//                str[textPtr]='0';
//                valB = Integer.parseInt(new String(str),2);
//                cash -= b;//we check which string is lesser then we are able to decide then we will initialize number of operations
//                b_way += countUgliness(textPtr-1,dp,a,b,cash,a_way,b_way,str,valA,valB);
//            }
//            if(valA<valB){
//                if(dp[textPtr]==-1) dp[textPtr]=0;
//                return dp[textPtr] += a_way;
//            }
//            if(dp[textPtr]==-1) dp[textPtr]=0;
//            return dp[textPtr] += b_way;
//    }

    public static void main(String[] args) {
        khaled();
    }
    static void khaled() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int[] dp = new int[n+1];
        System.out.println(computeKhaled(n-1,arr,dp,n/2,0));
    }

     static int computeKhaled( int n ,int[] arr, int[] dp, int limit,int maxXor) {
        if(dp[n]!=0) return dp[n];
        if(n==0 || limit==1) return arr[n];
        maxXor=Math.max(arr[n], arr[n]^computeKhaled(n-1,arr,dp,limit-1,maxXor));
        return dp[n]=maxXor;
    }

}
class Solution1 {
    static String str;
    static int cash, n, a, b;

    static void swapf() {
        char s[] = str.toCharArray();
        int i = 0;
        for (int a = 0; a < s.length; a++)
            if (s[a] == '1') {
                i = a;
                break;
            }
        int j = s.length - 1;

        while (j > i) {
            if (cash < a)
                break;
            //here we just check if we have 0 in i then we swap
            if (s[j] == '0') {
                if (s[i] == '0')
                    i++;
                else {
                    char temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                    cash -= a;
                    j--;
                }
            } else
                j--;
        }
        str = new String(s);
    }

    static void flipf() {
        char s[] = str.toCharArray();
        int i = 0;
        //here we are checking if we are able to get 1st one or not if we get  then we are assigning it
        for (int a = 0; a < s.length; a++)
            if (s[a] == '1') {
                i = a;
                break;
            }
        while (cash >= b) {
            if (i == s.length)
                break;
            //here we are redcing the number as well as cash till we have cash
            if (s[i] == '1') {
                s[i] = '0';
                i++;
                cash -= b;
            }
        }
        str = new String(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        str = sc.next ();
        cash = sc.nextInt ();
        a = sc.nextInt ();
        b = sc.nextInt ();

        if (a < b)
        {
            swapf ();
            flipf ();
        }
        else
        {
            flipf ();
            swapf ();
        }
        System.out.println (Integer.parseInt (str, 2));
    }
}
