class Solution {
    List<List<Integer>> retList;
    List<Integer> currentList;
    int[] map;

    void recursive (int i, int n){
        if (i == n) {
            List<Integer> newList = new ArrayList(currentList);
            retList.add(newList);
            return;
        }
        currentList.add(map[i]);
        recursive (i+1, n);

        currentList.remove(currentList.indexOf(map[i]));
        recursive (i+1, n);
    }

    public List<List<Integer>> subsets(int[] nums) {
        retList = new ArrayList();
        map = nums;
        currentList = new ArrayList();
        recursive (0, nums.length);
        return retList;
    }
}