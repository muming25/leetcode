class Solution {
    public void setZeroes(int[][] matrix) {
        int xlen = matrix.length;
        int ylen = matrix[0].length;
        boolean[] xmap = new boolean[xlen];
        boolean[] ymap = new boolean[ylen];
        for (int x = 0; x < xlen; x++){
            for (int y = 0; y < ylen; y++){
                if(matrix[x][y] == 0) {
                    xmap[x] = true;
                    ymap[y] = true;
                }
            }
        }
        for (int x = 0; x < xlen; x++){
            for (int y = 0; y < ylen; y++){
                if(xmap[x] || ymap[y]) {
                    matrix[x][y] = 0;
                }
            }
        }
    }
}