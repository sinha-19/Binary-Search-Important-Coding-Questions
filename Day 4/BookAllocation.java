public class BookAllocation {
    /*
     * Problem: Allocate books to minimize the maximum number of pages assigned to a student.
     * Approach: Binary search on answer (pages).
     * Time Complexity: O(n log sum)
     * Space Complexity: O(1)
     */
    public int allocate(int[] books, int students) {
        if (books.length < students) return -1;
        int low = 0, high = 0;
        for (int book : books) {
            low = Math.max(low, book);
            high += book;
        }
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAllocate(books, students, mid)) {
                result = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return result;
    }
    private boolean canAllocate(int[] books, int students, int maxPages) {
        int total = 0, required = 1;
        for (int book : books) {
            if (total + book > maxPages) {
                required++;
                total = book;
            } else total += book;
        }
        return required <= students;
    }
}
