/**
 * Return all overlapping intervals between two sorted arrays of intervals.
 * Each interval is represented as a pair of integers [start, end].
 * The intervals in each array are sorted by their start values, and there are no overlapping intervals within each array.
 *  
 * Example:
 * Input: A = [[1, 4], [5, 6], [9, 10]], B = [[2, 7], [8, 9]]
 * Output: [[2, 4], [5, 6], [9, 9]]
 * 
 * Explanation:
 * The intervals in A are: 1-4, 5-6, and 9-10.
 * The intervals in B are: 2-7 and 8-9.
 * The overlapping intervals are:
 * 1. 2-4 (from A[0] and B[0])
 * 2. 5-6 (from A[1] and B[0])
 * 3. 9-9 (from A[2] and B[1])
 */

class Solution {
    public static List<int[]> getOverlaps(int[][] A, int[][] B) {
        // Initialize a list to store the overlapping intervals
        List<int[]> result = new ArrayList<>();

        // Two pointers to iterate through arrays A and B
        int i = 0, j = 0;

        // Loop until one of the arrays is fully traversed
        while (i < A.length && j < B.length) {
            // Get start and end of current interval from A and B
            int start1 = A[i][0], end1 = A[i][1];
            int start2 = B[j][0], end2 = B[j][1];

            // Calculate the potential overlap
            int start = Math.max(start1, start2); // Start of overlap
            int end = Math.min(end1, end2);       // End of overlap

            // If the intervals overlap (i.e., start <= end), add to result
            if (start <= end) {
                result.add(new int[]{start, end});
            }

            // Move the pointer that has the smaller end value,
            // because that interval cannot overlap with any future intervals
            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }

        // Return the list of overlapping intervals
        return result;
    }
}
