public class RowWithMax1s {
    /*
     * Problem: Find the row with the maximum number of 1's in a binary matrix.
     * Each row is sorted in non-decreasing order (0s followed by 1s).
     * Approach: Start from top-right and move accordingly.
     * Time Complexity: O(n + m)
     */
    public int rowWithMaxOnes(int[][] mat) {
        int row = 0, col = mat[0].length - 1;
        int maxRow = -1;
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == 1) {
                maxRow = row;
                col--;
            } else {
                row++;
            }
        }
        return maxRow;
    }
}
