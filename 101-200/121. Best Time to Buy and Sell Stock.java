class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            int reward = prices[i] - min;
            if(reward > ret){
                ret = reward;
            }
        }
        return ret;
    }
}