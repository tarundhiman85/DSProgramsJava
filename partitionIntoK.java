public class partitionIntoK {
    public static void main(String[] args) {
        int n=5,k=3;
//        System.out.println( countPartitionRecursion(n,k));
        int [][] dp = new int[n+1][k+1];
//        System.out.println(countPartitionMemoization(n,k,dp));
        System.out.println(countPartitionTabulation(n,k,dp));
//        for(int i=0; i<dp.length; i++){
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
        }


    private static int countPartitionTabulation(int n, int k, int[][] dp) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                if (i == 0 || j == 0 || j > i) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j == i || j == 1){
                    dp[i][j] = 1;
                    continue;
                  }

                int left=dp[i-1][j-1];
                int right = dp[i-1][j];
                dp[i][j]=left+right*j;
            }
        }
        return dp[n][k];
    }

    private static int countPartitionMemoization(int n, int k, int[][] dp) {
        if(k==n || k==1) return dp[n][k]=1;
        if(n==0 || k==0 || k>n) return dp[n][k]=0;

        if(dp[n][k]!=0) return dp[n][k];
        int left = countPartitionMemoization(n-1,k-1,dp);
        int right = countPartitionMemoization(n-1,k,dp);
        return dp[n][k]=left+right*k;
    }

    private static int countPartitionRecursion(int n, int k) {
        if(n==0 || k==0 || k>n) return 0;
        if(k==n || k==1) return 1;
        int left = countPartitionRecursion(n-1,k-1);
        int right = countPartitionRecursion(n-1,k);
        return left+right*k;
    }
}
