class Solution {

    public static int maxProfit(int[] prices) {
        int[] hasStock = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        // 0 : buy first time, 1: buy second time
        int[] noStock = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        // 0 : sell first time, 1: sell second time

        for (int i = 0; i < prices.length; i++){
            int[] nextHasStock = new int[2];
            //hasStock[0]
            if (hasStock[0] <= 0 - prices[i]){
                nextHasStock[0] = 0 - prices[i];
            } else {
                nextHasStock[0] = hasStock[0];
            } 

            //hasStock[1]
            if (noStock[0] != Integer.MIN_VALUE && hasStock[1] <= noStock[0] - prices[i]){
                nextHasStock[1] = noStock[0] - prices[i];
            } else {
                nextHasStock[1] = hasStock[1];
            } 

            //noStock[0]
            if (hasStock[0] != Integer.MIN_VALUE && noStock[0] < hasStock[0] + prices[i]){
                noStock[0] = hasStock[0] + prices[i];
            } 

            //noStock[1]
            if (hasStock[1] != Integer.MIN_VALUE && noStock[1] < hasStock[1] + prices[i]){
                noStock[1] = hasStock[1] + prices[i];
            }
            
            hasStock[0] = nextHasStock[0];
            hasStock[1] = nextHasStock[1];
        }
        return Math.max(0, Math.max(noStock[0], noStock[1]));
    }
}