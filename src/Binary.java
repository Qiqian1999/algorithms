public class Binary {
    /* 371. Sum of Two Integers
    Given two integers a and b, return the sum of the two integers without using the operators + and -.
     */
    public int getSum(int a, int b) {
        int carry = (a&b)<<1;
        int ans = a^b;
        while(carry != 0){
            int temp = ans;
            ans = ans ^ carry;
            carry = (temp & carry)<<1;
        }
        return ans;
    }
    /* 191. Number of 1 Bits
    Write a function that takes an unsigned integer
    and returns the number of '1' bits it has (also known as the Hamming weight).
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        if(n>=0){
            while(n>0){
                ans += n%2;
                n=n/2;
            }
            return ans;
        }else{
            n = ~n;
            while(n>0){
                ans += n%2;
                n=n/2;
            }
            return 32-ans;
        }
    }
    /* 338. Counting Bits
    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
    ans[i] is the number of 1's in the binary representation of i.
     */
    public int[] countBits(int n) {
        if(n == 0){
            return new int[]{0};
        }
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;
        for(int i = 2; i<n+1; i++){
            ans[i] = i%2 + ans[i/2];
        }
        return ans;
    }
    /* 268. Missing Number
    Given an array nums containing n distinct numbers in the range [0, n],
    return the only number in the range that is missing from the array.
     */
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i<=nums.length;i++){
            ans ^=i;
        }
        for(int i = 0; i<nums.length;i++){
            ans ^=nums[i];
        }
        return ans;
    }
    /* 190. Reverse Bits
    Reverse bits of a given 32 bits unsigned integer.
     */
    public int reverseBits(int n) {
        int ans = 0;
        int start = 1;
        int end = 31;
        while(end >=0){
            if((start&n)!=0){
                ans |= 1<<end;
            }
            start = start<<1;
            end--;
        }
        return ans;
    }

}
