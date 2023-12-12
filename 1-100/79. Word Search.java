class Solution {
    boolean[][] passed;
    char[][] map;
    String target;

    boolean trace(int x, int y, int i){
        if (i == target.length()){
                return true;
        }
        else if (x == map.length || x < 0 ||
            y == map[0].length || y < 0){
                return false;
        }
        else if (!passed[x][y] && map[x][y] == target.charAt(i)) {
            passed[x][y] = true;
            if( trace(x+1, y, i+1) ||  trace(x, y+1, i+1) || 
                trace(x-1, y, i+1) ||  trace(x, y-1, i+1)) {
                 return true;
            }
            passed[x][y] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length){
            return false;
        }
        map = board;
        target = word;
        passed = new boolean[board.length][board[0].length];
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if (trace(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}