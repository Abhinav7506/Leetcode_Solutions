class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int x=0;
        int n= intervals.length;
        int[][] ans = new int[n+1][2];
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                ans[x++] = new int[]{start, end};
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans[x++] = new int[]{start, end};
        return Arrays.copyOf(ans, x);     
    }
}