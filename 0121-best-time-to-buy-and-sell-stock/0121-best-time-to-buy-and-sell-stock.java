class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0,min=prices[0],profit=0;;
        for(int i=1;i<prices.length;i++){
            profit=prices[i]-min;
            maxProfit=Math.max(maxProfit,profit);
            min=Math.min(min,prices[i]);
        }
        return maxProfit;
    }
}