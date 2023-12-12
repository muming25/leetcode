class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] maxHeights = new int[heights.length];
        int max = 0;
        for (int i=0; i<heights.length; i++) {
            if (maxHeights[i] == heights[i]){
                continue;
            }
            int r, l;
            for (r = i+1; r < heights.length; r++) {
                if (heights[r] < heights[i]) {
                    break;
                }
            }
            for (l = i-1; l >= 0; l--) {
                if (heights[l] < heights[i]) {
                    break;
                }
            }
            int thisRect = heights[i] * (r - l - 1);
            if(thisRect > max){
                max = thisRect;
                for (int j = l+1; j < r-1; j++) {
                    maxHeights[j] = heights[i];
                }
            }
        }
        return max;
    }
}