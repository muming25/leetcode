class Solution {
    public void nextPermutation(int[] nums) {
        int minnum = Integer.MAX_VALUE;
        int minindex = -1;
        int i=nums.length-2;
        for(;i>=0;i--){
            if(nums[i+1]>nums[i]){
                for(int j=i;j<nums.length;j++){
                    if(minnum > nums[j] && nums[j]>nums[i]){
                        minnum = nums[j];
                        minindex = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[minindex];
                nums[minindex] = temp;
                break;
            }
        }
        i++;
        for(;i<nums.length-1;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        
    }
}