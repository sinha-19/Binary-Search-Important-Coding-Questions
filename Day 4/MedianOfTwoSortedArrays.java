public class MedianOfTwoSortedArrays {
    /*
     * Problem: Find median of two sorted arrays.
     * Approach: Binary Search on smaller array partition.
     * Time Complexity: O(log(min(n, m)))
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays(B, A);
        int n1 = A.length, n2 = B.length;
        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : A[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : B[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : A[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : B[cut2];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else low = cut1 + 1;
        }
        return 0.0;
    }
}
