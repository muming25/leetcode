class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
		// map[i] means the max subarray-sum start from nums[0] to nums[i-1] which end at nums[i]
        int[] map = new int[nums.length];
        int cur = 0;

        // first loop, calculate subarray-sum(0, n) to subarray-sum(n, n)
        for (int i = 0; i < nums.length; i++) {
            map[i] = nums[i];
            if (nums[i] > max){
                max = nums[i];
            }
            cur += nums[i];
			
            if (cur > max){
                max = cur;
            }
			
            if (cur > map[i]){
                map[i] = cur;
            }
        }

        if (max <= 0){
            return max;
        }

        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];
            for (int j = 1; i + j < nums.length; j++) {
				// Calculate subarray-sum(i, i+1) to subarray-sum(i, n)
                cur += nums[i+j];
                if (cur < map[i+j]) {
					// While the subarray-sum(k, i+j) is greater than the subarray-sum(i, i+j), indicating that 
					//     subarray-sum(i, l) is always greater than subarray-sum(k, l) when l >= i+j, 
					//     the subarray-sum(i, i+j) can be omitted.
                    break;
                }
				
                if (cur > max){
                    max = cur;
                }
				
                if (cur > map[i+j]){
                    map[i+j] = cur;
                }
            }
        }
        return max;
    }
}