import java.util.Scanner;

public class PeakColumns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input matrix A dimensions
            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            int columns = scanner.nextInt();

            if (rows <= 0 || columns <= 0) {
                System.out.println("Invalid matrix dimensions. Rows and columns must be positive integers.");
                return;
            }

            // Display matrix A dimensions
            System.out.println("Matrix A: " + rows + ", " + columns);

            // Input matrix elements
            int[][] matrix = new int[rows][columns];
            System.out.println("Enter the matrix elements row by row:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Find and display peak-columns
            boolean foundPeakColumn = false;
            for (int i = 0; i < rows; i++) {
                // Assume the first element in the row is the maximum
                int maxInRow = matrix[i][0];
                int maxColumnIndex = 0;

                // Find the maximum element in the current row
                for (int j = 1; j < columns; j++) {
                    if (matrix[i][j] > maxInRow) {
                        maxInRow = matrix[i][j];
                        maxColumnIndex = j;
                    }
                }

                // Check if the maximum element is also the minimum in its column
                boolean isMinInColumn = true;
                for (int k = 0; k < rows; k++) {
                    if (matrix[k][maxColumnIndex] < maxInRow) {
                        isMinInColumn = false;
                        break;
                    }
                }

                // If both conditions are met, it's a peak-column
                if (isMinInColumn) {
                    System.out.println("(" + (i + 1) + "," + (maxColumnIndex + 1) + ") = " + maxInRow);
                    foundPeakColumn = true;
                }
            }

            if (!foundPeakColumn) {
                System.out.println("No peak-columns found.");
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter only integers.");
        } finally {
            scanner.close();
        }
    }
}
