public class FindPeakElement {
    /*
     * Problem: Find any peak element (greater than neighbors) in the array.
     * Approach: Use binary search to find mid where peak condition is satisfied.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
