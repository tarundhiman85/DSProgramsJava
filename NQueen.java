import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NQueen {
    private static void solve(int col, char[][] board, ArrayList<ArrayList<Integer>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal){
        if(col==board.length){
            res.add(construct(board));
            return;
        }
        for(int row = 0; row<board.length; row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[board.length-1+col-row]==0){
                board[row][col]='Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[board.length-1+col-row]=1;
                solve(col+1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                //reset to normal
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length - 1 + col -row] = 0;
            }
        }
    }
    private static ArrayList<Integer> construct(char[][] board){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='Q') res.add(j+1);
            }
        }
        return res;
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int [] leftRow = new int[n];
        int [] upperDiagonal = new int[2*n-1];
        int [] lowerDiagonal = new int[2*n-1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        //sort the result by the first by using comparator
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()==o2.size()){
                    for(int i=0; i<o1.size(); i++){
                        if(o1.get(i)>o2.get(i)) return 1;
                        else if(o1.get(i)<o2.get(i)) return -1;
                    }
                }
                else if(o1.size()>o2.size()) return 1;
                else return -1;
                            return 0;
            }
        });

        return res;
    }
    public static void main(String[] args) {
        System.out.println(nQueen(9));
    }
}
