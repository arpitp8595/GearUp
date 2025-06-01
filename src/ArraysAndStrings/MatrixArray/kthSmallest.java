package src.ArraysAndStrings.MatrixArray;

public class kthSmallest {

    //Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    //Output: 13
    //Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(getkthSmallest(matrix, k)); // Output: 13
    }

    // O((m \times n) \log(max - min))
    //O(1)
    public static int getkthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];

        // Binary search for the k-th smallest element
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = n - 1;

            // Count the number of elements less than or equal to `mid`
            for (int[] ints : matrix) {
                while (j >= 0 && ints[j] > mid) {
                    j--;
                }
                count += j + 1;
            }

            // Adjust search range based on the count
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

