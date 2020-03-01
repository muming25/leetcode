class Solution {
    boolean[][] table_row = new boolean[9][10];
    boolean[][] table_col = new boolean[9][10];
    boolean[][][] table_block = new boolean[3][3][10];
    char[][] output;
    private boolean solve(int x,int y){

        if(output[x][y]=='.'){
            for(int num=1;num<=9;num++){
                if( !table_row[x][num] && 
                    !table_col[y][num] &&
                    !table_block[x/3][y/3][num]){
                    table_row[x][num] = true;
                    table_col[y][num] = true;
                    table_block[x/3][y/3][num] = true;
                    output[x][y] = (char)((int)'0' + num) ;
                    if(x==8 && y==8){
                        return true;
                    }
                    boolean ret = solve(x+((y+1)/9),(y+1)%9);
                    if(ret){
                        return ret;
                    }else{
                        table_row[x][num] = false;
                        table_col[y][num] = false;
                        table_block[x/3][y/3][num] = false;
                        output[x][y] = '.';
                    }
                }
            }
        }else{
            if(x==8 && y==8){
                return true;
            }
            return solve(x+((y+1)/9),(y+1)%9);
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        for (int x=0;x<9;x++){
            for (int y=0;y<9;y++){
                if(board[x][y]=='.'){continue;}
                int num = board[x][y] - '0';
                table_row[x][num] = true;
                table_col[y][num] = true;
                table_block[x/3][y/3][num] = true;
            }
        }
        output = board;
        solve(0,0);
    }
}