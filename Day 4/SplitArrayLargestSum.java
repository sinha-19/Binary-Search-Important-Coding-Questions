public class SplitArrayLargestSum {
    /*
     * Problem: Split array into m parts with minimized largest subarray sum.
     * Approach: Binary search on answer (sum).
     * Time Complexity: O(n log sum)
     * Space Complexity: O(1)
     */
    public int splitArray(int[] nums, int m) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canSplit(nums, m, mid)) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }
    private boolean canSplit(int[] nums, int m, int maxSum) {
        int subarrays = 1, current = 0;
        for (int num : nums) {
            if (current + num > maxSum) {
                subarrays++;
                current = num;
            } else current += num;
        }
        return subarrays <= m;
    }
}
