import java.util.Arrays;
public class BinarySearchFindX {
    /*
     * Problem: Given a sorted array and a target value X, find the index of X.
     * If not found, return -1.
     * Approach: Classic Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
