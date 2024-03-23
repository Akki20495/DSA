package DataSheets;

public class NumMatrix {
    public static void main(String[] args) {
        // Input matrix
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        // Create a NumMatrix object to calculate sum of submatrices
        Main numMatrix = new Main(matrix);

        // Query and print the sum of elements in specified submatrices
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // Output: 12
    }
}

class Main {
    private int[][] prefix; // 2D array to store prefix sums

    public Main(int[][] matrix) {
        if (matrix.length == 0)
            return;

        final int m = matrix.length; // Number of rows in the matrix
        final int n = matrix[0].length; // Number of columns in the matrix
        prefix = new int[m + 1][n + 1]; // Initialize prefix sum array with an extra row and column

        // Calculate prefix sums for each cell in the matrix
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                prefix[i + 1][j + 1] = matrix[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Calculate sum of elements in the specified submatrix using prefix sum array
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] -
                prefix[row2 + 1][col1] + prefix[row1][col1];
    }
}
