class Solution {
    List<List<Integer>> retList;
    List<Integer> currentList;

    void recursive (int i, int n, int k, int c){
        if (c == k) {
            List<Integer> newList = new ArrayList(currentList);
            retList.add(newList);
            return;
        } else if (k-c > n-i+1) {
            return;
        }
        currentList.add(i);
        recursive (i+1, n, k, c+1);

        currentList.remove(currentList.indexOf(i));
        recursive (i+1, n, k, c);
    }

    public List<List<Integer>> combine(int n, int k) {
        retList = new ArrayList();
        if ( k <= n ) {
            currentList = new ArrayList();
            recursive (1, n, k, 0);
        }
        return retList;
    }
}