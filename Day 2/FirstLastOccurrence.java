public class FirstLastOccurrence {
    /*
     * Problem: Find the first and last occurrence of a given number in a sorted array.
     * Approach: Perform binary search twice — once for first and once for last index.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        int first = findIndex(nums, target, true);
        int last = findIndex(nums, target, false);
        return new int[]{first, last};
    }
    private int findIndex(int[] nums, int target, boolean findFirst) {
        int low = 0, high = nums.length - 1, index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                index = mid; // Record the index
                if (findFirst) high = mid - 1;
                else low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
