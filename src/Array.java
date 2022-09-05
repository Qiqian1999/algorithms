import java.util.ArrayList;
import java.util.HashMap;
public class Array {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> data = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int leftOver = target- cur;
            if(data.get(leftOver) != null){
                return new int[]{i, data.get(leftOver)};
            }
            data.put(cur, i);

        }
        return new int[]{0,0};
    }
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];
        for(int i = 0; i < prices.length; i++){
            int sellPrice = prices[i];
            buyPrice = Math.min(buyPrice, sellPrice);
            if( sellPrice - buyPrice > profit){
                profit = sellPrice - buyPrice;
            }
        }


        return profit;
    }
}
