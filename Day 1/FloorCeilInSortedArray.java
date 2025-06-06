public class FloorCeilInSortedArray {
    /*
     * Problem: For a given target in a sorted array:
     * - Floor: Greatest element <= target
     * - Ceil: Smallest element >= target
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findFloor(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int floor = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return nums[mid];
            else if (nums[mid] < target) {
                floor = nums[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return floor;
    }
    public int findCeil(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ceil = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return nums[mid];
            else if (nums[mid] > target) {
                ceil = nums[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ceil;
    }
}
