class Solution {
    public int maximalRectangle(char[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int[] heights = new int[w]; 

        int max = 0;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        heights[j] = 1;
                    } else {
                        heights[j] ++;
                    }
                } else {
                    heights[j] = 0;
                }
            }
            for (int j=0; j<w; j++) {
                if (matrix[i][j] == '1') {
                    int l=j, r=j;
                    while (l > 0 && heights[l-1] >= heights[j]) {
                        if (heights[l-1] == heights[j]) {
                            matrix[i][l-1] = '0';
                        }
                        l--;
                    }
                    while (r < w-1 && heights[r+1] >= heights[j]) {
                        if (heights[r+1] == heights[j]) {
                            matrix[i][r+1] = '0';
                        }
                        r++;
                    }
                    int cur = heights[j] * (r-l+1);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
}