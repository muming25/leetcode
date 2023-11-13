class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                } else {
                    if (i > 0) {
                        obstacleGrid[i][j] += obstacleGrid[i-1][j];
                    }
                    if (j > 0) {
                        obstacleGrid[i][j] += obstacleGrid[i][j-1];
                    }
                }
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }
}