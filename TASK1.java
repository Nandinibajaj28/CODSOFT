import java.util.*;
class numberguessing{
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int score = 0;

        while (true) {
                int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                //to give the random number in the range of  1 to 100

                int attempts = 0;//let atttempt is 0

                //when attempts are less than 5(let)
                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess number:");

                    //if input is not an integer
                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        scanner.next();
                        continue;
                    }
                    //if input is an integer
                    int guess = scanner.nextInt();
                    attempts++;
    
                    //check if guess number is less than random number, then number is too low
                    if (guess < numberToGuess) {
                        System.out.println("Too low number, Try again");
                    } 
                    //check if guess number is more than random number, then number is too high
                    else if (guess > numberToGuess) {
                        System.out.println("Too high number, Try again");
                    } 
                    //check if guess number is random number, then correct guess
                    else {
                        System.out.println(" Correct guess in " + attempts + " attempts.");
                        score++;
                        break;
                    }
                }
                //reach the max attempts
                if (attempts == maxAttempts) {
                    System.out.println("Sorry! The number was " + numberToGuess + ". Better luck next time!");
                }
    
                //final score
                System.out.println("Your current score: " + score);
                //next round?
                System.out.print("Do you want to play another round? (yes/no): ");

                String playAgain = scanner.next().trim().toLowerCase();
                //not want to play
                if (!playAgain.equals("yes")) {
                    System.out.println("Thanks for playing! Final Score: " + score);
                    break;
                }
            }
            scanner.close();
        }
}
