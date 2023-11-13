class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList();
        if(matrix.length == 0 || matrix[0].length == 0){
            return ret;
        }
        boolean[][] table = new boolean[matrix.length+2][matrix[0].length+2];
        int x=1, y=1;
        int direct[][] = new int[][]{
          { 0, 1},
          { 1, 0},
          { 0, -1},
          { -1, 0}
        };
        for (int i=0;i<table.length;i++){
            table[i][table[0].length-1] = true;
            table[i][0] = true;
        }
        for (int i=0;i<table[0].length;i++){
            table[table.length-1][i] = true;
            table[0][i] = true;
        }
        int direct_index = 0;
        int count = matrix.length * matrix[0].length;
        ret.add(matrix[x-1][y-1]);
        table[x][y] = true;
        count--;
        while(count>0){
            if(table[x + direct[direct_index][0]][y + direct[direct_index][1]]==false){
                x += direct[direct_index][0];
                y += direct[direct_index][1];
                ret.add(matrix[x-1][y-1]);
                table[x][y] = true;
                count--;
            }else{
                direct_index = (direct_index+1)%4;
            }
        }
        return ret;
    }
}