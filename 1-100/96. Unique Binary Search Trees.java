class Solution {
    public int numTrees(int n) {
        int[] map = new int[n+1];
        map[0] = 1;
        map[1] = 1;
        for(int i=2; i<n+1; i++){
            for(int j=0; j<i; j++){
                map[i] += map[j] * map[i-1-j];
            }
        }
        return map[n];
    }
}