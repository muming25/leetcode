class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int STATE_RIGHT = 0;
        int STATE_DOWN = 1;
        int STATE_LEFT = 2;
        int STATE_UP = 3;
        int STATE_MAX = 4;
        int STATE = STATE_RIGHT;
        
        int i=0;
        int j=0;
        int iAdd=0;
        int jAdd=0;
        int count = 1;
        while(count <= n*n){
            if (ret[i][j] == 0) {
                ret[i][j] = count;
                count++;
            }
            if (STATE == STATE_RIGHT) {
                if (j < n - 1 && ret[i][j+1] == 0) {
                    j++;
                } else {
                    STATE = (STATE + 1) % STATE_MAX;
                }
            } else if (STATE == STATE_DOWN ){
                if (i < n - 1 && ret[i+1][j] == 0) {
                    i++;
                } else {
                    STATE = (STATE + 1) % STATE_MAX;
                }
            } else if (STATE == STATE_LEFT) {
                if (j > 0 && ret[i][j-1] == 0) {
                    j--;
                } else {
                    STATE = (STATE + 1) % STATE_MAX;
                }
            } else if (STATE == STATE_UP) {
                if (i > 0 && ret[i-1][j] == 0){
                    i--;
                } else {
                    STATE = (STATE + 1) % STATE_MAX;
                }
            }
        }
        return ret;
    }
}.