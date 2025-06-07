public class NthRootOfNumber {
    /*
     * Problem: Find nth root of m.
     * Approach: Binary search from 1 to m.
     * Time Complexity: O(log m * log n)
     * Space Complexity: O(1)
     */
    public int nthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            long val = power(mid, n);
            if (val == m) return mid;
            else if (val < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    private long power(int base, int exp) {
        long result = 1;
        while (exp-- > 0) {
            result *= base;
            if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return result;
    }
}
