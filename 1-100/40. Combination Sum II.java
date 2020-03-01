class Solution {
    List<List<Integer>> ret;
    int[] Candidates;
    private void sum(List<Integer> cur, int remain, int index){
        if(index == -1){
            return;
        }
        sum(cur, remain, index-1);
        if(remain - Candidates[index] == 0){
            List<Integer> next = new ArrayList(cur);
            next.add(Candidates[index]);
            if(!ret.contains(next)){
                ret.add(next);
            }
        }else if(remain - Candidates[index] > 0){
            List<Integer> next = new ArrayList(cur);
            next.add(Candidates[index]);
            sum(next, remain - Candidates[index], index-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ret = new ArrayList();
        Candidates = candidates;
        List<Integer> cur = new ArrayList();
        sum(cur, target, candidates.length-1);
        return ret;
    }
}