class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] ans = new int[n + 1][2];
        int x=0;
        int i=0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            ans[x++] = intervals[i++];
        }
        int start = newInterval[0];
        int end = newInterval[1];
         while (i < n && intervals[i][0] <= end) {
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        ans[x++] = new int[]{start, end};
        while (i < n) {
            ans[x++] = intervals[i++];
        }

        return Arrays.copyOf(ans, x);
    }
}