import java.util.*;

class Question {
    String questionText;
    String options[];
    String correctAnswer;

    // Constructor to initialize the question, options, and correct answer
    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class TASK3 {
    private static final int TIME_LIMIT = 30;
     
    private static int score = 0; 
     
    private static ArrayList<Question> questions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create quiz questions
        questions.add(new Question("What is the capital of France?", new String[]{"A) Berlin", "B) Madrid", "C) Paris", "D) Rome"}, "C"));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"A) Earth", "B) Mars", "C) Jupiter", "D) Saturn"}, "B"));
       
        
        startQuiz();
    }

    // Method 
    private static void startQuiz() {
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.questionText);
            displayOptions(question.options);

            // Start timer for each question
            boolean answered = askQuestionWithTimer(question);
            if (!answered) {
                System.out.println("Time's up!");
            }
        }

        // Display final results
        displayResults();
    }

    // Method to display multiple-choice options
    private static void displayOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    // Method to handle question answering with timer
    private static boolean askQuestionWithTimer(Question question) {
        final boolean[] answered = {false};
        Timer timer = new Timer();

        // Schedule a task to end the question after TIME_LIMIT seconds
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered[0]) {
                    System.out.println("Time is up! You did not answer.");
                    answered[0] = true;
                }
            }
        }, TIME_LIMIT * 1000);  // Convert seconds to milliseconds

        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().toUpperCase().trim();

        // Check if the answer is correct and update the score
        if (!userAnswer.isEmpty() && userAnswer.equals(question.correctAnswer)) {
            score++;
        }
        answered[0] = true; // Mark the question as answered
        return true;
    }

    //  final score and results
    private static void displayResults() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());
        System.out.println("Summary of Answers:");

        // Display the correct/incorrect answers
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + question.questionText);
            System.out.println("Correct Answer: " + question.correctAnswer);
        }
    }
}

