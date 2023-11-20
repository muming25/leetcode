class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int x = 0; x < matrix.length; x++){
            for (int y = 0; y < matrix[0].length; y++){
                if (matrix[x][y] > target) {
                    return false;
                } else if (matrix[x][y] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}