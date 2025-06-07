public class KthElementOfTwoSortedArrays {
    /*
     * Problem: Find kth element in the union of two sorted arrays.
     * Approach: Binary Search on partition.
     * Time Complexity: O(log(min(n, m)))
     */
    public int findKthElement(int[] A, int[] B, int k) {
        if (A.length > B.length) return findKthElement(B, A, k);
        int n = A.length, m = B.length;
        int low = Math.max(0, k - m), high = Math.min(k, n);
        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = k - cutA;
            int l1 = cutA == 0 ? Integer.MIN_VALUE : A[cutA - 1];
            int l2 = cutB == 0 ? Integer.MIN_VALUE : B[cutB - 1];
            int r1 = cutA == n ? Integer.MAX_VALUE : A[cutA];
            int r2 = cutB == m ? Integer.MAX_VALUE : B[cutB];
            if (l1 <= r2 && l2 <= r1)
                return Math.max(l1, l2);
            else if (l1 > r2) high = cutA - 1;
            else low = cutA + 1;
        }
        return 0;
    }
}
