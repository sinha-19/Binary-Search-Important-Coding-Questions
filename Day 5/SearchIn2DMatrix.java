public class SearchIn2DMatrix {
    /*
     * Problem: Search for a target in a 2D matrix where each row is sorted, and the first element
     * of each row is greater than the last element of the previous row.
     * Approach: Treat matrix as 1D array and apply binary search.
     * Time Complexity: O(log(m*n))
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows * cols - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midElement = matrix[mid / cols][mid % cols];
            if (midElement == target) return true;
            else if (midElement < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
