class Solution {
    public int maximalSquare(char[][] matrix) {
        int len_x = matrix.length;
        int len_y = matrix[0].length;
        int [][] map = new int[len_x][len_y];
        int ret = 0;
        for(int i=0; i<len_x; i++){
            map[i][0] = matrix[i][0] - '0';
            if (map[i][0] == 1) {
                ret = 1;
            }
        }
        for(int j=0; j<len_y; j++){
            map[0][j] = matrix[0][j] - '0';
            if (map[0][j] == 1) {
                ret = 1;
            }
        }
        for(int i=1; i<len_x; i++){
            for(int j=1; j<len_y; j++){
                int cur = matrix[i][j] - '0';
                if (cur == 0) {
                    map[i][j] = 0;
                } else {
                    int map_i_j = Math.min(map[i-1][j], Math.min(map[i][j-1], map[i-1][j-1]));
                    map[i][j] = map_i_j + 1;
                    if (map[i][j] > ret) {
                        ret = map[i][j];
                    }
                }
            }
        }
        return ret * ret;
    }
}