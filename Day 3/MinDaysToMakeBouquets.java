public class MinDaysToMakeBouquets {
    /*
     * Problem: Minimum days to make m bouquets of k adjacent flowers.
     * Approach: Binary search on day range.
     * Time Complexity: O(n log max)
     * Space Complexity: O(1)
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int low = 1, high = 0;
        for (int day : bloomDay) high = Math.max(high, day);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }
    private boolean canMake(int[] bloom, int m, int k, int days) {
        int flowers = 0, bouquets = 0;
        for (int b : bloom) {
            if (b <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
