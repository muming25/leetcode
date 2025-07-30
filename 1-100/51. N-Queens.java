class Solution {
    String[] ans;
    List<List<String>> ret;
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

    void rec(int n, int index, boolean[] flag, int[] map) {
        if(index == n){
            List list = new ArrayList<String>();
            for (int i=0; i<n; i++) {
                list.add(ans[map[i]]);
            }
            ret.add(list);
            return;
        }
        for (int i=0; i < n; i++) {
            if(check(index, flag, map, i)){
                flag[i] = true;
                map[index] = i;
                rec(n, index+1, flag, map);
                flag[i] = false;
            }
        }
        return;
    }
    
    public List<List<String>> solveNQueens(int n) {
        String empty = "";
        for (int i=0; i<n; i++) {
            empty = empty + ".";
        }
        ans = new String[n];
        for (int i=0; i<n; i++) {
            String newString = empty.substring(0,i)+'Q'+empty.substring(i+1);
            ans[i] = newString;
        }
        boolean[] flag = new boolean[n];
        int[] map = new int[n];
        ret = new ArrayList<List<String>>();
        rec(n, 0, flag, map);
        return ret;
    }
}