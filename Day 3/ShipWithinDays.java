import java.util.Arrays;
public class ShipWithinDays {
    /*
     * Problem: Ship packages within D days with minimum capacity.
     * Approach: Binary search on weight capacity.
     * Time Complexity: O(n log sum)
     * Space Complexity: O(1)
     */
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canShip(weights, days, mid)) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }
    private boolean canShip(int[] weights, int days, int capacity) {
        int current = 0, requiredDays = 1;
        for (int w : weights) {
            if (current + w > capacity) {
                requiredDays++;
                current = w;
            } else current += w;
        }
        return requiredDays <= days;
    }
}
