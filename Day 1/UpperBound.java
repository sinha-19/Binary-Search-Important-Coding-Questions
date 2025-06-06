public class UpperBound {
    /*
     * Problem: Return the index of the first element > target in a sorted array.
     * If not found, return array length.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
