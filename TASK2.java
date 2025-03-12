import java.util.*;

public class TASK2 {
    
    
    public static void calculate(int marks[]) {
        int total_Marks = 0;  
        int total_Subjects = marks.length;  // Number of subjects
        for (int mark : marks) {
            total_Marks += mark;  // Add marks of each subject
        }
        
        // Calculate the average percentage
        double average_Percentage = (double) total_Marks / (total_Subjects * 100) * 100;
        
        // Grade calculation based on average percentage
        String grade;

        if (average_Percentage >= 90) {
            grade = "A";
        } else if (average_Percentage >= 80) {
            grade = "B";
        } else if (average_Percentage >= 70) {
            grade = "C";
        } else if (average_Percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        // Display the results
        System.out.println("Total Marks: " + total_Marks + " / " + (total_Subjects * 100));
        System.out.println("Average Percentage: " + String.format("%.2f", average_Percentage) + "%");
        System.out.println("Grade: " + grade);
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter the number of subjects: ");
        int total_Subjects = scanner.nextInt();
        
        // Initialize the marks array
        int marks[] = new int[total_Subjects];
        
        // Input marks for each subject
        for (int i = 0; i < total_Subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        
        calculate(marks);
        
        scanner.close();
    }
}
