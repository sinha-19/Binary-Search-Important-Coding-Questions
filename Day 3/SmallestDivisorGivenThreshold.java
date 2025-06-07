import java.util.Arrays;
public class SmallestDivisorGivenThreshold {
    /*
     * Problem: Find smallest divisor such that sum of ceil(nums[i]/divisor) <= threshold.
     * Approach: Binary search between 1 and max(nums).
     * Time Complexity: O(n log max)
     * Space Complexity: O(1)
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum <= threshold) {
                result = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return result;
    }
}
