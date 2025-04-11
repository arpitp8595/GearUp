package ArraysAndStrings;

public class BestTimeToBuyAndSellStocks2 {

    //Medium 122. Best Time to Buy and Sell Stock II : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

    public static void main(String[] args) {
        int[] array = {7,4,900,111,6700,340,1000};
        System.out.println("Best time to buy stocks: "+ maxProfit(array));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}