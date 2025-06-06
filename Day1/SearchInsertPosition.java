public class SearchInsertPosition {
    /*
     * Problem: Return the index if the target is found.
     * If not, return the index where it would be inserted in order.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
