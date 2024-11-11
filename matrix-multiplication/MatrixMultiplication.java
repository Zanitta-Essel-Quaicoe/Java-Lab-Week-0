import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for matrix A dimensions and it elements
        System.out.print("Enter the dimensions of Matrix A (n, m): ");

        //Initialize matrix A
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] A = new int[n][m];
        System.out.println("Enter the elements of Matrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        // Input for matrix B dimensions and it elements
        System.out.print("Enter the dimensions of Matrix B (m, p): ");
        int m2 = scanner.nextInt();
        int p = scanner.nextInt();

        if (m != m2) {
            System.out.println("Matrix multiplication is not possible. The number of columns in A must be equal to the number of rows in B.");
            return;
        }

        //Initialize Matrix B
        int[][] B = new int[m][p];
        System.out.println("Enter the elements of Matrix B:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        // Initialize Matrix C
        int[][] C = new int[n][p];

        // Matrix multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Determine maximum width for formatting
        int maxWidth = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                maxWidth = Math.max(maxWidth, String.valueOf(C[i][j]).length());
            }
        }

        // Result for matrix multiplication
        System.out.println("Matrix C:");
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < p; j++) {
                System.out.print(String.format("%" + maxWidth + "d ", C[i][j]));
            }
            System.out.print("|");
            System.out.println();
        }
        
        scanner.close();
    }
}
