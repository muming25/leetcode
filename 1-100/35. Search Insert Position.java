class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int left=0, right = nums.length - 1, center = (left+right)/2;
        while(nums[center] != target && right > left){
            if(nums[left] < nums[right]){
                if(target > nums[center]){
                    left = center+1;
                }else{
                    right = center-1;
                }
            }
            center = (left+right)/2;
        }
        if(nums[center] < target){
            return center + 1;
        }
        else{
            return center;
        }
    }
}