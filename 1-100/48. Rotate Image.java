class Solution {
    private void swap(int[][] matrix,int x,int y,int x2,int y2){
        int temp = matrix[x][y];
         matrix[x][y] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
    public void rotate(int[][] matrix) {
        int length = matrix[0].length-1;
        for(int i=0;i<length;i++){
            for(int j=i;j<length-i;j++){
                swap(matrix,i,j,j,length-i);
                swap(matrix,i,j,length-j,i);
                swap(matrix,length-j,i,length-i,length-j);
            }
        }
    }
}