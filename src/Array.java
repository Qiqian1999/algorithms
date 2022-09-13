import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Array {
    /* 1. Two Sum
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
    /* Best Time to Buy and Sell Stock
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
    /* 217. Contain Duplicate
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        boolean ans = false;
        for(int i =0; i<nums.length; i++){
            if(set.contains(nums[i])){
                ans=true;
            }else{
                set.add(nums[i]);
            }
        }
        return ans;

    }
    /* 238. Product of Array Except Self
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.
     */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int preMul = 1;
        for(int i = 0; i < nums.length; i++){
            ans[i] = preMul;
            preMul *= nums[i];
        }
        int sufMul = 1;
        for(int i = nums.length-1; i >=0; i--){
            ans[i] = ans[i] * sufMul;
            sufMul *= nums[i];
        }
        return ans;
    }
    /* 53. Maximum Subarray
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.
     */
    public int maxSubArray(int[] nums) {
        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(maxSum[i-1]<0){
                maxSum[i] = nums[i];
            }else{
                maxSum[i] = nums[i] + maxSum[i-1];
            }
            if(maxSum[i] > ans){
                ans = maxSum[i];
            }
        }
        return ans;
    }
    /* 11. Container With Most Water
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int startIndex = 0;
        int endIndex = height.length-1;
        boolean moveStart = height[startIndex]<height[endIndex];
        while(startIndex<endIndex){
            int water = Math.min(height[startIndex],height[endIndex])*(endIndex-startIndex);
            if(water > ans){
                ans = water;
            }
            int original = Math.min(height[startIndex],height[endIndex]);
            if(moveStart){
                while(startIndex<endIndex && height[startIndex]<=original){
                    startIndex++;
                }
            }else{
                while(startIndex<endIndex && height[endIndex]<=original){
                    endIndex--;
                }

            }
            moveStart = height[startIndex]<height[endIndex];
        }
        return ans;

    }
}
