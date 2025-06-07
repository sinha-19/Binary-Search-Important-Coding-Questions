public class SquareRootOfNumber {
    /*
     * Problem: Find floor value of square root of a non-negative number.
     * Approach: Binary search between 1 to x.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int mySqrt(int x) {
        if (x < 2) return x;
        int low = 1, high = x, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }
}
