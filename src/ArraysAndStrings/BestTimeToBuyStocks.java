package ArraysAndStrings;

public class BestTimeToBuyStocks {
    public static void main(String[] args) {
        int[] array = {7,4,9,1,6,3,0};
        System.out.println("Best time to buy stocks: "+ getBestTimeToBuyStock(array));
    }
    //Easy: 121. Best time to buy and sell stocks : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    private static int getBestTimeToBuyStock(int[] array) {
        int buyPrice = array[0];
        int maxProfit = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < buyPrice) {
                buyPrice = array[i];
            }
            maxProfit = Math.max(maxProfit,  array[i] - buyPrice);
        }
    return maxProfit;
    }
}
