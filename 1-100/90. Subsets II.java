class Solution {
    List<List<Integer>> retList;
    List<Integer> currentList;
    int[] map;
    void recursive (int i, int n){
        if (i == n) {
            Collections.sort(currentList);
            List<Integer> newList = new ArrayList(currentList);
            if(!retList.contains(newList)) {
                retList.add(newList);
            }
            return;
        }
        currentList.add(map[i]);
        recursive (i+1, n);

        currentList.remove(currentList.indexOf(map[i]));
        recursive (i+1, n);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
            retList = new ArrayList();
            map = nums;
            currentList = new ArrayList();
            recursive (0, nums.length);
            return retList;
    }
}