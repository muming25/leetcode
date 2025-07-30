class Solution {
    boolean check(int index, boolean[] flag, int[] map, int val){
        if (flag[val]) {
            return false;
        }
        for(int i = index-1; i>=0; i--){
            int diff = index - i;
            if (map[i] == val + diff || map[i] == val - diff) {
                return false;
            }
        }
        return true;
    }

    int rec(int n, int index, boolean[] flag, int[] map, int count) {
        if(index == n){
            return count + 1;
        }
        for (int i=0; i < n; i++) {
            if(check(index, flag, map, i)){
                flag[i] = true;
                map[index] = i;
                count = rec(n, index+1, flag, map, count);
                flag[i] = false;
            }
        }
        return count;
    }
    
    public int totalNQueens(int n) {
        boolean[] flag = new boolean[n];
        int[] map = new int[n];
        int ret = rec(n, 0, flag, map, 0);
        return ret;
    }
}