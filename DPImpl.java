import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;


public class DPImpl implements DP{

    public static BigInteger findCatalan(int n)
    {
        //last visit 21/11
        BigInteger[] dp=new BigInteger[n+1];
        //firstly we will create the array to 0
        for(int i=0;i<=n;i++)
            dp[i]=BigInteger.ZERO;
        //then we create the some base conditions
        dp[0]=BigInteger.ONE;
        dp[1]= BigInteger.ONE;

        //then we loop though for each value and calculate the dp based on previous value
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i]= dp[i].add(dp[j].multiply(dp[i-j-1]));
            }
        }
        return dp[n];
    }
    @Override
    public int minOperation(int n)
    {
        //code here.
        int dp[] = new int[1000000];
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<=n+1; i++){
            int p1 =Integer.MAX_VALUE;
            int p2 =Integer.MAX_VALUE;
            if(i%2==0){
                p1=dp[i/2];
            }
            p2 = dp[i-1];
            dp[i] = (p1>p2?p2:p1)+1;

        }
        return dp[n];
    }
    @Override
    public int lcs(char[] a, char[] b, int m, int n){
        //last visit 23/11
        //we just check if they are equal or not
        //then we increment the count

        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(a[i-1]==b[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
    @Override
    public int lCommSs(char[] a, char[] b, int m, int n){
        //last visit 23/11
        //we check if they are equal but if we found the breakse we give that count 0
        //hence we are able to find the max count
        int dp[][] = new int[m+1][n+1];
        int result = 0;
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(a[i]==b[j])
                {
                    dp[i][j] = 1+ dp[i-1][j-1];
                    result = result<dp[i][j]?result:dp[i][j];
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n][m];
    }
    public String reverse(String s){
        int start = 0;
        int end = s.length()-1;
        char[] ch = s.toCharArray();
        while(start<end){
            char temp;
            temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            end--;
            start++;
        }
        return new String(ch);
    }
    @Override
    public int minStepToDeleteString(String a)
    {
        // Your code goes here last visit 23/11
        //we will reverse the string and get commonsubsequnce
        //and from the original length we will subtract the lps to get minimum

        String b = reverse(a);
        // System.out.println(b);
        int longestCS = lcs(a.toCharArray(), b.toCharArray(), a.length(), b.length());
        return a.length() - longestCS;
        //System.out.println(longestCS);
        //return 1;
    }
    @Override
    public int rodCutting(int[] prices){
        //last visit 21/11
        int[] np = new int[prices.length+1];

        for(int i=0; i<prices.length; i++){
            np[i+1] = prices[i];
        }

        int[] dp = new int[np.length];
        dp[0]=0;
        dp[1]=np[1];

        for(int i=2; i<np.length; i++){

            int left = 1;
            int right = i-1;

            dp[i] = np[i];

            while(left<=right){
                if(dp[left]+dp[right]>dp[i]){
                    dp[i] = dp[left] + dp[right];
                }
                left++;
                right--;
            }
        }
        return dp[dp.length-1];
    }
    @Override
    public void countHops(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        if(n==0||n==1){
            System.out.println(1);
        }
        long[] dp = new long[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=n; i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000007;
        }
        System.out.println( dp[n]);
    }
    @Override
    public void gridpaths() {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int org=n;
        ArrayList<String> grid = new ArrayList<>();
        while (org-->0){
            grid.add(sc.next());
        }
        char[][] ch = new char[n][n];
        int j=0;
        for(String a: grid){
            for(int i=0; i<a.length(); i++){
                ch[j][i]=a.charAt(i);
            }
            j++;
        }
        if((n==1 || n==2) && ch[0][0]=='*'){
            System.out.println(0);
            return;
        }
        long[][]dp=new long[n+1][n+1];
        for(int i=0; i<=n ; i++){
            for( j=0; j<=n; j++){
                dp[i][j]=-1L;
            }
        }

        System.out.println(countGrid(n-1,n-1,dp, ch));
    }
    static long countGrid(int i, int j, long[][] dp, char[][] ch) {
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(ch[i][j]=='*'){
            return 0;
        }
        return dp[i][j]=(countGrid(i-1,j,dp,ch)%1000000007+countGrid(i,j-1,dp,ch)%1000000007)%1000000007;
    }
    private long count(int i, int n, long[] dp) {
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        long op1 = count(i+1,n,dp)%1000000007;
        long op2 = count(i+2,n,dp)%1000000007;
        long op3 = count(i+3,n,dp)%1000000007;
        // System.out.println(op1+" "+op2+" "+op3);
         dp[n] = (op1 + op2 + op3);
         dp[n] = dp[n]%1000000007;
         return dp[n];
    }
    static long remove( int n, long[] dp){

     String a = String.valueOf(n);
     int l=a.length();
     ArrayList<Integer> digitA = new ArrayList<>();

     if(n==0){
         return dp[n];
     }

     if(dp[n]!=Integer.MAX_VALUE){
         return dp[n];
     }
     for(int i=0; i<l; i++)
     {
         digitA.add(Character.getNumericValue(a.charAt(i)));
     }
         for(int k=0; k<l; k++){
             if(digitA.get(k)!=0){
                 dp[n]=Math.min(dp[n],remove(n-digitA.get(k),dp)+1);
             }
     }
     return dp[n];
    }
    static long removeDigits(){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp= new long[n+1];

        dp[0]=0;

        for(int i=1; i<=n; i++){
            dp[i]=Integer.MAX_VALUE;
        }

        for(int i=1; i<=n; i++)
        {
            if(countDigit(i)>=2){
                int k=i;
                while(k!=0){
                    if(k%10!=0) {
                        dp[i] = Math.min(dp[i - (k % 10)] + 1, dp[i]);
                    }
                    k/=10;
                }
            }
            else{
                dp[i]=Math.min(dp[0]+1,dp[i]);
            }

        }
        return dp[n];
    }
    private static int countDigit(int i) {
        int cnt=0;
        while(i!=0){
            i/=10;
            cnt++;
        }
        return cnt;
    }
    @Override
    public void arrayDescription(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] values = new int[n];
        for(int i=0; i<n; i++){
            values[i]=sc.nextInt();
        }
//        int[][] numberOfArrays=new int[n+1][m+1];
//        ArrayList<ArrayList<Long>> numberOfArrays = new ArrayList<>(n+1);
//        ArrayList<Long> test = new ArrayList<>(m+1);
//        numberOfArrays.add(test);
//
//        if(values[0]!=0){
//            numberOfArrays.set(0);
//        }
//        IntStream.rangeClosed(0, n).forEach(i -> dp[i] = -1);
//        System.out.println(countDescriptions(n-1,n,m,arr,dp));
    }

//    private int countDescriptions(int currPos,int n, int m, int[] arr, int[] dp) {
//
//        if(currPos==0) return 0;
//
//        if(dp[currPos]!=0) return dp[currPos];
//
//
//        if(arr[currPos]==0){
//            for(int i=1; i<=m; i++){
//                if(currPos==n-1 && ( ((Math.abs(arr[currPos-1]-i))==0)|| ((Math.abs(arr[currPos-1]-i))==1) ) ) {
//                    arr[currPos]=i;
//                    dp[currPos]=1+countDescriptions(currPos-1,n,m,arr,dp);
//                }
//                else if(   (Math.abs(arr[currPos+1]-i)==1 || Math.abs(arr[currPos+1]-i)==0)
//                        && (Math.abs(arr[currPos-1]-i)==1 || Math.abs(arr[currPos-1]-i)==0) )
//                {
//                    arr[currPos]=i;
//                    if(dp[currPos]==-1) dp[currPos]=0;
//                    dp[currPos]+=(1+countDescriptions(currPos-1,n,m,arr,dp));
//                }
//            }
//        }
//        else if(currPos!=n-1){
//            if((Math.abs(arr[currPos+1]-arr[currPos])==1 || Math.abs(arr[currPos+1]-arr[currPos])==0)
//                    && (Math.abs(arr[currPos-1]-arr[currPos])==1 || Math.abs(arr[currPos-1]-arr[currPos])==0) ){
//                if(dp[currPos]==-1) dp[currPos]=0;
//                dp[currPos]+=(1+countDescriptions(currPos-1,n,m,arr,dp));
//            }
//        }
//        else{
//            dp[currPos]=countDescriptions(currPos-1,n,m,arr,dp);
//        }
//        return dp[currPos];
//    }

    public static void main(String[] args) {
        DP dp=new DPImpl();
        dp.arrayDescription();
    }

    @Override
    public void bookShop() {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] price =new int[n];
        for(int i=0; i<n; i++){
            price[i]=sc.nextInt();
        }
        int[] page =new int[n];
        for(int i=0; i<n; i++){
            page[i]= sc.nextInt();
        }
        int[][] dp=new int[n+1][x+1];
        for(int i=1; i<=n; i++) {
            for (int j = 0; j <= x; j++) {
                //option1 = book number i-1 is not included, hence no pages added.
                //option2 = book number i-1 is included, hence pages are added.
                //option1 = dp[i-1][j] ...book not included so total price(j) remains same.
                //option2 = dp[i-1][j-price[i-1]] + page[i-1]....total price(j) decreased and pages are counted for book i-1.
                //j stands for available price
                //i stands for total no of books to consider

                //if available price is less then the actual price then we sure dont consider it
                dp[i][j] = dp[i - 1][j];
                //else we have the option
                if (j >= price[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - price[i - 1]] + page[i - 1]); //max of both the boxes included in dp[i][j].
                }
            }
        }
            System.out.println(dp[n][x]);
    }

    static int knapSackRec(int W, int wt[],
                           int val[], int n,
                           int [][]dp)
    {

        // Base condition
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W)

            // Store the value of function call
            // stack in table before return
            return dp[n][W] = knapSackRec(W, wt, val,
                    n - 1, dp);

        else

            // Return value of table after storing
            return dp[n][W] = Math.max((val[n - 1] +
                            knapSackRec(W - wt[n - 1], wt,
                                    val, n - 1, dp)),
                    knapSackRec(W, wt, val,
                            n - 1, dp));
    }

}
