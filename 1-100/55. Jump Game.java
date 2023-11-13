class Solution {
    public boolean canJump(int[] nums) {
        boolean[] table = new boolean[nums.length];
        table[0] = true;
        for(int i=0;i<nums.length;i++){
            if(table[i] == true){
                for(int j=1;j<=nums[i] && i+j<nums.length;j++){
                    table[i+j] = true;
                }
            }
        }
        return table[nums.length-1];
    }
}