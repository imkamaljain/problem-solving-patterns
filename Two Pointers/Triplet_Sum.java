/*
Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0.
The solution must not contain duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are considered duplicates).
If no such triplets are found, return an empty array.
Each triplet can be arranged in any order, and the output can be returned in any order.

Input: nums = [0, -1, 2, -3, 1]
Output: [[-3, 1, 2], [-1, 0, 1]]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to apply two-pointer technique and handle duplicates
        Arrays.sort(nums);

        // Iterate through the array, treating each number as a fixed starting point
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1; // Start of the two-pointer
            int right = nums.length - 1; // End of the two-pointer

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Check if the sum is zero
                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers
                    left++;
                    right--;
                } else if (sum < 0) {
                    // If sum is too small, move left pointer to increase sum
                    left++;
                } else {
                    // If sum is too large, move right pointer to decrease sum
                    right--;
                }
            }
        }

        return result;
    }
}
