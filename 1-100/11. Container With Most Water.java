class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        for(int i = 0;i<len - 1;i++){
            for(int j = i;j<len;j++){
                int min = height[j];
                if(height[j]>height[i]){
                    min = height[i];
                }
                int current = (j-i)*min;
                if(max < current){
                    max = current;
                }
            }
        }
        return max;
    }
}