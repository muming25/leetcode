class Solution {
    public int[] twoSum(int[] nums, int target) {
                   int[] output = new int[2];
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
               if(nums[i]+nums[j]==target){
                   output[0]=i;
                   output[1]=j;
                   return output;
               }
            }
        }
        return output;
    }
}