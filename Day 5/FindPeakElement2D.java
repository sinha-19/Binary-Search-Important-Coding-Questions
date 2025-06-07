public class FindPeakElement2D {
    /*
     * Problem: Find a peak element in a 2D matrix.
     * An element is a peak if it's strictly greater than its neighbors (up, down, left, right).
     * Approach: Binary search on columns.
     * Time Complexity: O(n * log m)
     */
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int low = 0, high = cols - 1;
        while (low <= high) {
            int midCol = (low + high) / 2;
            int maxRow = 0;
            for (int i = 0; i < rows; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol])
                    maxRow = i;
            }
            boolean leftIsSmaller = midCol == 0 || mat[maxRow][midCol] > mat[maxRow][midCol - 1];
            boolean rightIsSmaller = midCol == cols - 1 || mat[maxRow][midCol] > mat[maxRow][midCol + 1];
            if (leftIsSmaller && rightIsSmaller)
                return new int[]{maxRow, midCol};
            else if (!leftIsSmaller)
                high = midCol - 1;
            else
                low = midCol + 1;
        }
        return new int[]{-1, -1};
    }
}
