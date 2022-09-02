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
}
