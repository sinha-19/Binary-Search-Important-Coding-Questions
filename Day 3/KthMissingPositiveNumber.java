public class KthMissingPositiveNumber {
    /*
     * Problem: Find the kth missing positive number in a sorted array.
     * Approach: Binary search on array index.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return low + k;
    }
}
