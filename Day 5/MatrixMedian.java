public class MatrixMedian {
    /*
     * Problem: Find the median in a row-wise sorted matrix.
     * Approach: Binary search on value range (1 to 1e9).
     * Time Complexity: O(32 * rows * log(cols)) ≈ O(log(max) * rows * log(cols))
     */
    public int findMedian(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 1, high = (int) 1e9;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int[] row : matrix) {
                count += countSmallerEqual(row, mid);
            }
            if (count <= (rows * cols) / 2) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return low;
    }
    private int countSmallerEqual(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] <= target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
