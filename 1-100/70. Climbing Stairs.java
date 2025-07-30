class Solution {
    public int climbStairs(int n) {
        int[] map = new int[n+1];
        map[0] = 1;
        map[1] = 1;
        for(int i=2; i<=n; i++){
            map[i] = map[i-1] + map[i-2];
        }
        return map[n];
    }
}