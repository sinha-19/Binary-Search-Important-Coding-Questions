import java.util.Arrays;
public class AggressiveCows {
    /*
     * Problem: Place cows in stalls such that the minimum distance between any two cows is maximized.
     * Approach: Binary Search on answer (distance).
     * Time Complexity: O(n log(max-min))
     * Space Complexity: O(1)
     */
    public int maxDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlace(stalls, cows, mid)) {
                result = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return result;
    }
    private boolean canPlace(int[] stalls, int cows, int dist) {
        int count = 1, last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
            }
        }
        return count >= cows;
    }
}
