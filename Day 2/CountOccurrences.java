public class CountOccurrences {
    /*
     * Problem: Count occurrences of a number in a sorted array with duplicates.
     * Approach: Find the first and last index of the element using binary search.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int countOccurrences(int[] nums, int target) {
        int first = findIndex(nums, target, true);
        if (first == -1) return 0;
        int last = findIndex(nums, target, false);
        return last - first + 1;
    }
    private int findIndex(int[] nums, int target, boolean findFirst) {
        int low = 0, high = nums.length - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                res = mid;
                if (findFirst) high = mid - 1;
                else low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
