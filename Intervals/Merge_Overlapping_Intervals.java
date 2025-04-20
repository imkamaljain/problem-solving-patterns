/*
Merge an array of intervals so there are no overlapping intervals, and return the resultant merged intervals.

Input: intervals = [[3, 4], [7, 8], [2, 5], [6, 7], [1, 4]]
Output: [[1, 5], [6, 8]]
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        // If there's 0 or 1 interval, no merge is needed
        if (intervals.length <= 1) return intervals;

        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Stack to hold the merged intervals
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]); // Push the first interval

        // Iterate over the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // Get the last interval from the stack
            int[] top = stack.peek();

            // Check for overlap with the current interval
            if (top[1] >= intervals[i][0]) {
                // Merge the intervals by updating the end time
                top[1] = Math.max(top[1], intervals[i][1]);
            } else {
                // No overlap; push the current interval to stack
                stack.push(intervals[i]);
            }
        }

        // Convert the stack to an array and return
        return stack.stream().toArray(int[][]::new);
    }
}