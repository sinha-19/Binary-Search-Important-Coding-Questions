public class SearchInRowColSortedMatrix {
    /*
     * Problem: Search for a target in a matrix where each row and column is sorted.
     * Approach: Start from top-right corner.
     * Time Complexity: O(m + n)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
