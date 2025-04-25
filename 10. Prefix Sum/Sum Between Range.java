/**
 * Given an array of integers, write a function which returns the sum of values between two indexes.
 * The function should be able to handle multiple queries efficiently.
 * 
 * Example:
 * Input: nums = [3, -7, 6, 0, -2, 51], queries =  [sum_range(0, 3), sum_range(2, 4), sum_range(2, 2)]
 * Output: [2, 4, 6]
 * 
 * Explanation:
 * The array contains integers: 3, -7, 6, 0, -2, and 51.
 * The queries are:
 * 1. sum_range(0, 3): The sum of values from index 0 to 3 is 3 + (-7) + 6 + 0 = 2.
 * 2. sum_range(2, 4): The sum of values from index 2 to 4 is 6 + 0 + (-2) = 4.
 * 3. sum_range(2, 2): The sum of values from index 2 to 2 is just the value at index 2, which is 6.
 * Therefore, the output is [2, 4, 6].
 */

class Solution {
    private int[] prefixSum;

    // Constructor to initialize prefix sum
    public Solution(int[] nums) {
        // Compute prefix sum
        prefixSum = new int[nums.length + 1]; // one extra for ease of computation
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    // Returns the sum from index start to end (inclusive)
    public int sum_range(int start, int end) {
        return prefixSum[end + 1] - prefixSum[start];
    }
}