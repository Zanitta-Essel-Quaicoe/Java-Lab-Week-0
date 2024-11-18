import java.util.Arrays;
import java.util.Scanner;

public class StatisticsOfGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students in the class: ");
        int N = scanner.nextInt(); // The number of students in the class
        scanner.nextLine(); // Consume the newline left-over from nextInt()

        double[] scores = new double[N]; // An array of size N to store the grades as double

        System.out.print("Enter the grades of students in the class (separated by spaces): ");
        String inputLine = scanner.nextLine(); // Read the entire line of grades
        String[] gradeStrings = inputLine.trim().split("\\s+"); // Split grades by spaces

        // Check if the number of grades entered matches N
        if (gradeStrings.length < N) {
            System.out.println("Error: Fewer grades entered than the number of students (" + N + "). Please restart and enter exactly " + N + " grades.");
            scanner.close();
            return;
        } else if (gradeStrings.length > N) {
            System.out.println("Error: More grades entered than the number of students (" + N + "). Please restart and enter exactly " + N + " grades.");
            scanner.close();
            return;
        }

        // Parse and validate the grades into the scores array
        for (int i = 0; i < N; i++) {
            try {
                double grade = Double.parseDouble(gradeStrings[i]);

                // Check if the grade is within the valid range 0-100 inclusive
                if (grade < 0 || grade > 100) {
                    System.out.println("Error: Grade " + grade + " is out of the valid range (0-100). Please restart and enter grades within the range.");
                    scanner.close();
                    return;
                }
                
                scores[i] = grade;
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + gradeStrings[i] + "' is not a valid number. Please restart and enter numeric grades only.");
                scanner.close();
                return;
            }
        }

        // Finding the maximum, minimum, and average grade of the class
        double maxGrade = scores[0];
        double minGrade = scores[0];
        double totalGrade = 0.0;

        for (int i = 0; i < N; i++) { // Loop for finding the maximum and minimum grades
            if (scores[i] > maxGrade) {
                maxGrade = scores[i];
            }
            if (scores[i] < minGrade) {
                minGrade = scores[i];
            }
            totalGrade += scores[i]; // Sum all grades
        }

        double averageGrade = totalGrade / N; // Compute average grade of the class

        System.out.printf("The maximum grade of the class is %.2f%n", maxGrade); // Print max with 2 decimal places
        System.out.printf("The minimum grade of the class is %.2f%n", minGrade); // Print min with 2 decimal places
        System.out.printf("The average grade of the class is %.2f%n", averageGrade);

        // Generating bar chart in the console
        int[] stats = new int[5];  // To hold grade ranges as specified

        // Loop for categorizing the grades
        for (double score : scores) {
            if (score > 80) { // Grades above 80
                stats[4] += 1;
            } else if (score >= 61) { // Grades from 61 to 80
                stats[3] += 1;
            } else if (score >= 41) { // Grades from 41 to 60
                stats[2] += 1;
            } else if (score >= 21) { // Grades from 21 to 40
                stats[1] += 1;
            } else { // Grades from 0 to 20
                stats[0] += 1;
            }
        }

        // Determine the maximum count in stats for graph height
        int maxStatistics = Arrays.stream(stats).max().orElse(0);

        // Print the bar chart
        for (int i = maxStatistics; i > 0; i--) {
            // Print the row label 
            System.out.printf("%4d >", i);
            
            // Loop through each range in stats and print a bar if count >= current row
            for (int count : stats) {
                if (count >= i) {
                    System.out.print("  #######  ");
                } else {
                    System.out.print("           ");
                }
            }
            System.out.println(); // Move to the next line after each row
        }

        // Print the base line and labels
        System.out.println("    +-----------+-----------+-----------+-----------+-----------+");
        System.out.println("    I   0-20    I  21-40    I  41-60    I  61-80    I  81-100   I");

        scanner.close();
    }
}
