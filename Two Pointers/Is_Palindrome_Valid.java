/*
A palindrome is a sequence of characters that reads the same forward and backward.
Given a string s, determine if it's a palindrome after removing all non-alphanumeric characters.
A character is alphanumeric if it's either a letter or a number.

Input: s = "a dog! a panic in a pagoda"
Output: true
*/

class Solution {
    public boolean isPalindrome(String s) {
        // Initialize two pointers: one at the start, one at the end of the string
        int left = 0;
        int right = s.length() - 1;

        // Loop while left pointer is before right pointer
        while (left < right) {
            // Move left pointer forward if current character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move right pointer backward if current character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare the characters at left and right (ignoring case)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;  // Characters don't match — not a palindrome
            }

            // Move both pointers toward the center
            left++;
            right--;
        }

        // All character comparisons passed — it's a palindrome
        return true;
    }
}
