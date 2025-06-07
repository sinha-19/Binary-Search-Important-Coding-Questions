import java.util.PriorityQueue;
public class MinimizeMaxDistanceGasStation {
    /*
     * Problem: Minimize maximum distance between gas stations with k new stations.
     * Approach: Binary Search + Heap OR Greedy
     * Time Complexity: O(n log(1/epsilon))
     * Space Complexity: O(1)
     */
    public double minmaxGasDist(int[] stations, int k) {
        double low = 0.0, high = stations[stations.length - 1] - stations[0];
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            if (canPlace(stations, k, mid)) {
                high = mid;
            } else low = mid;
        }
        return low;
    }
    private boolean canPlace(int[] stations, int k, double dist) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            count += (int) ((stations[i] - stations[i - 1]) / dist);
        }
        return count <= k;
    }
}
