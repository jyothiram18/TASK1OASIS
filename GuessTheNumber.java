5import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10; // You can change this to limit the number of attempts
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I've selected a random number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please enter a number within the valid range.");
                continue;
            }

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You've guessed the number (" + randomNumber + ") in " + attempts + " attempts.");
                score += (maxAttempts - attempts) * 10; // You can adjust the scoring system
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        }

        if (attempts >= maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber);
        }

        System.out.println("Your score: " + score);
        scanner.close();
    }
}