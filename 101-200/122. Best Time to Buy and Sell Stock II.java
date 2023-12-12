class Solution {
    public int maxProfit(int[] prices) {
        //first day
        int hasStock = 0 - prices[0];
        int noStock = 0;

        for (int i = 1; i < prices.length-1; i++){
            int nexHasStock;
            //hasStock
            if (hasStock <= noStock - prices[i]){
                nexHasStock = noStock - prices[i];
            } else {
                nexHasStock = hasStock;
            } 

            //noStock
            if (noStock < hasStock + prices[i]){
                noStock = hasStock + prices[i];
            } 
            hasStock = nexHasStock;
        }

        //final day
        if (noStock <= hasStock + prices[prices.length-1]){
            noStock = hasStock + prices[prices.length-1];
        } 
        return noStock;
    }
}