class Solution {
    public int removeDuplicates(int[] nums) {
        int ret = 0;
        int last_num = -100000;
        int last_count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == last_num && last_count >= 2 ) {
                continue;
            } else {
                nums[ret] = nums[i];
                if (nums[ret] == last_num) {
                    last_count ++;
                } else {
                    last_count = 1;
                }
                last_num = nums[ret];
                ret++;
            }
        }
        return ret;
    }
}