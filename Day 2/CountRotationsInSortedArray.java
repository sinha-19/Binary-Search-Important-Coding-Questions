public class CountRotationsInSortedArray {
    /*
     * Problem: Find the number of times a sorted array has been rotated.
     * Approach: Find index of minimum element using binary search.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int countRotations(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
