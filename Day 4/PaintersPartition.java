public class PaintersPartition {
    /*
     * Problem: Minimize the time to paint boards by k painters.
     * Each painter can paint only continuous sections.
     * Time Complexity: O(n log sum)
     */
    public int minTime(int[] boards, int k) {
        int low = 0, high = 0;
        for (int b : boards) {
            low = Math.max(low, b);
            high += b;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPaint(boards, k, mid)) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }
    private boolean canPaint(int[] boards, int k, int maxTime) {
        int painters = 1, total = 0;
        for (int b : boards) {
            if (total + b > maxTime) {
                painters++;
                total = b;
            } else total += b;
        }
        return painters <= k;
    }
}
