public class FindMinimumInRotatedArray {
    /*
     * Problem: Find the minimum element in a rotated sorted array.
     * Approach: Binary search for the unsorted half where minimum lies.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
