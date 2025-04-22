/**
 * Problem:
 * Given a string s, determine if it is a palindrome after removing all non-alphanumeric characters.
 * A character is alphanumeric if it's either a letter or a number.
 * 
 * Example:
 * Input: s = "a dog! a panic in a pagoda"
 * Output: true
 * 
 * Explanation:
 * The string "a dog! a panic in a pagoda" is a palindrome when ignoring spaces and punctuation.
 * The alphanumeric characters are: "adogapanicinapagoda"
 * which reads the same forward and backward.
 * Therefore, the output is true.
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
