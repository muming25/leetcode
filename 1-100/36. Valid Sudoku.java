class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] table_row = new boolean[9][10];
        boolean[][] table_col = new boolean[9][10];
        boolean[][][] table_block = new boolean[3][3][10];
        //boolean[][] hypotenuse = new boolean[2][10];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if(board[i][j]=='.'){continue;}
                int num = board[i][j] - '0';
                if( table_row[i][num] || 
                    table_col[j][num] ||
                    table_block[i/3][j/3][num]){
                    return false;
                }
                table_row[i][num] = true;
                table_col[j][num] = true;
                table_block[i/3][j/3][num] = true;
            }
        }
        return true;
    }
}