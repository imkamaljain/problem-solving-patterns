/**
 * Problem:
 * Given an array of integers, determine the maximum number of intervals that overlap at any point.
 * Each interval is half-open, meaning it includes the start point but excludes the end point.
 * 
 * Example:
 * Input: intervals = [[1, 3], [2, 6], [4, 8], [6, 7], [5, 7]]
 * Output: 3
 * 
 * Explanation:
 * The intervals are: 1-3, 2-6, 4-8, 6-7, and 5-7.
 * The maximum overlap occurs between intervals [2, 6], [4, 8], and [5, 7], which overlap at the point 6.
 * Therefore, the maximum number of overlapping intervals is 3.
 */

class Solution {
    
    // Helper class to represent a start or end of an interval
    static class Event {
        int time;        // The time of the event
        boolean isStart; // True if it's a start of an interval, false if it's an end

        Event(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static int maxOverlap(int[][] intervals) {
        List<Event> events = new ArrayList<>();

        // Convert each interval into two events: start and end
        for (int[] interval : intervals) {
            events.add(new Event(interval[0], true));  // start event
            events.add(new Event(interval[1], false)); // end event
        }

        // Sort the events:
        // - First by time
        // - If times are equal, 'start' should come before 'end'
        Collections.sort(events, (a, b) -> {
            if (a.time != b.time) {
                return a.time - b.time;  // earlier time first
            }
            return a.isStart ? -1 : 1;  // start before end if same time
        });

        int maxOverlap = 0;       // stores the maximum number of overlapping intervals
        int currentOverlap = 0;   // current number of active intervals

        // Process all events in order
        for (Event event : events) {
            if (event.isStart) {
                currentOverlap++;                       // a new interval has started
                maxOverlap = Math.max(maxOverlap, currentOverlap);  // update max if needed
            } else {
                currentOverlap--;  // an interval has ended
            }
        }

        return maxOverlap;
    }
}
