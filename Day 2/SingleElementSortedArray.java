public class SingleElementSortedArray {
    /*
     * Problem: In sorted array where every element appears twice except one, find the single element.
     * Approach: Use binary search with index parity trick.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == nums[mid ^ 1]) low = mid + 1;
            else high = mid - 1;
        }
        return nums[low];
    }
}
