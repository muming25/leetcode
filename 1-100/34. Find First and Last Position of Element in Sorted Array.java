class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = 0;
        int index = -1;
        int[] ret = {-1, -1};
        while (left <= right) {
            mid = (left + right) / 2;
            if ( nums[mid] == target ) {
                index = mid;
                break;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        if (index != -1) {
            ret[0] = index;
            ret[1] = index;
            while (ret[0] - 1 >= 0 && nums[ret[0] - 1] == target){
                ret[0]--;
            }

            while (ret[1] + 1 < nums.length && nums[ret[1] + 1] == target){
                ret[1]++;
            }
        }
        return ret;
    }
}