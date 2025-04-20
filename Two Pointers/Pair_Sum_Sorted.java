/*
Given an array of integers sorted in ascending order and a target value, 
return the indexes of any pair of numbers in the array that sum to the target.
The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.

Input: nums = [-5, -2, 3, 4, 6], target = 7
Output: [2, 3]
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Initialize two pointers: one at the start, one at the end
        int left = 0;
        int right = nums.length - 1;

        // Loop while left pointer is before right pointer
        while (left < right) {
            // Calculate the sum of the two pointed values
            int sum = nums[left] + nums[right];

            // If the sum matches the target, return their (1-based) indexes
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // Assuming 1-based indexing
            } 
            // If the sum is less than the target, move left pointer to increase the sum
            else if (sum < target) {
                left++;
            } 
            // If the sum is more than the target, move right pointer to decrease the sum
            else {
                right--;
            }
        }

        // No valid pair found, return an empty array
        return new int[] {};
    }
}
