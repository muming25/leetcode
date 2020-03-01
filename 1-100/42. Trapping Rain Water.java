class Solution {
    public int trap(int[] height) {
        int[] table = new int[height.length];
        int[] tableindex = new int[height.length];
        int index_of_max = 0;
        int top = 0;
        int output = 0;
        for(int i=0;i<height.length;i++){
            if(top == 0){
                if(height[i] == 0){
                    continue;
                }else{
                    height[top] = height[i];
                    top++;
                    index_of_max = i;
                }
            }
            
            if(height[i] < table[top-1]){
                table[top] = height[i];
                top++;
            }else if(height[i] > table[0]){
                for(int j=index_of_max;j<i;j++){
                    if(height[index_of_max] > height[j]){
                        output += height[index_of_max] - height[j];
                        height[j] = height[index_of_max];
                    }
                }
                top = 1;
                table[0] = height[i];
                index_of_max = i;
            }else if(height[i] > table[top-1]){
                for(int j=i-1;j>=0;j--){
                    if(height[i] > height[j]){
                        output += height[i] - height[j];
                        height[j] = height[i];
                    }else{
                        while(height[i] > table[top-1]){
                            top--;
                        }
                        if(height[i] != table[top-1]){
                            table[top] = height[i];
                            top++;
                        }
                        break;
                    }
                }
            }
        }
        return output;
    }
}