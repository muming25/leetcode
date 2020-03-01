class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int left=0, right = nums.length - 1, center = (left+right)/2;
        while(nums[center] != target && right - left >= 2){
            if(nums[left] < nums[right]){
                if(target > nums[center]){
                    left = center+1;
                }else{
                    right = center-1;
                }
            }else{
                if(nums[center] > nums[left]){
                    if(target >= nums[left] && target < nums[center]){
                        right = center-1;
                    }else{
                        left = center+1;
                    }
                }else{
                    if(target <= nums[right] && target > nums[center]){
                        left = center+1;
                    }else{
                        right = center-1;
                    }
                }
            }
            center = (left+right)/2;
        }
        if(nums[center] == target){
            return center;
        }
        else if(nums[left] == target){
            return left;
        }
        else if(nums[right] == target){
            return right;
        }
        else{
            return -1;
        }
    }
}