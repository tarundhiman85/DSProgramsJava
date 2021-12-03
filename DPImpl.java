import java.math.BigInteger;


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


    public static void main(String[] args) {
        BigInteger b = findCatalan(5);
        System.out.println(b);
    }

}
