class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }
        for (int i=0; i<nums.length; i++){
            if (count[0] > 0) {
                count[0]--;
                nums[i] = 0;
            } else if (count[1] > 0) {
                count[1]--;
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}