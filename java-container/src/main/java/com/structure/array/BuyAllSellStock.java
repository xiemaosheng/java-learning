package com.structure.array;

/**
 * Created by Administrator on 2017/8/6 0006.
 */
public class BuyAllSellStock {
    public static int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int maxProfit = 0;
        int curMin = prices[0];

        for(int i = 1;i < prices.length;i++){
            curMin = Math.min(curMin,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i] - curMin);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stock = new int[]{100,290,500,400,900,700,1000,50,990};
        System.out.println(maxProfit(stock));
    }
}
