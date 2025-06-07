public class KokoEatingBananas {
    /*
     * Problem: Find minimum bananas per hour to finish all piles in h hours.
     * Approach: Binary search between 1 and max(piles).
     * Time Complexity: O(n log max(pile))
     * Space Complexity: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) high = Math.max(high, pile);
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canEat(piles, h, mid)) {
                result = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return result;
    }
    private boolean canEat(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + k - 1) / k;
        }
        return time <= h;
    }
}
