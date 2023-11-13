class Solution {
    public int jump(int[] nums) {
        int[] table = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<=nums[i] && i+j<nums.length;j++){
                if(table[i+j]==0){
                    table[i+j] = table[i]+1;
                }
                if(table[i+j] > table[i]+1){
                    table[i+j] = table[i]+1;
                }
            }
        }
        return table[nums.length-1];
    }
}