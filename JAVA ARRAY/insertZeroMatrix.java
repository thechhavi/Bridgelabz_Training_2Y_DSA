class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 4},
            {9, 0, 8},
            {7, 6, 2}
        };
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRow = new boolean[rows];
        boolean[] zeroCol = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            if (zeroRow[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < cols; j++) {
            if (zeroCol[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}