public class longestIncPathHard {
    static int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int[][] mat={{1,2,9},{5,3,8},{4,6,7}};
        System.out.println(solve(mat));
    }
    static int solve(int[][] mat){
        if(mat==null || mat.length==0) return 0;
        int row = mat.length;
        int col = mat[0].length;
        int longestPath=0;
        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int longest = solveL(mat,cache,row,col,i,j);
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }

    private static int solveL(int[][] mat, int[][] cache, int row, int col, int i, int j) {
        if(cache[i][j]>0) return cache[i][j];
        int max = 0;
        //for each element[i][j] we are checking in all directions
        //if the particular element is less then the previous element that would not create a path
        //else if greater then that call will cause another call adding 1 to max which will further maxed with that prev call
        for(int[] direction : DIRECTIONS){
            int x = direction[0]+i;
            int y = direction[1]+j;
            if(x>-1 && y>-1 && x<row && y<col && mat[x][y]>mat[i][j]){
                int longest = solveL(mat,cache,row,col,x,y);
                max=Math.max(max,longest);
            }
            cache[i][j] = max+1;

        }
        return cache[i][j];
    }
}
