import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int secretNumber = generateSecretNumber();
        int attempts = 1;
        while (true) {
            int guess = playerGuess();
            attempts = checkGuess(secretNumber,guess, attempts);
        }
    }//end main

    public static int generateSecretNumber() {
        int secretNumber;
        Random random = new Random();
        secretNumber = random.nextInt(1,101);   // generates random int from 1-100
        return secretNumber;
    }//end generateSecretNumber()

    public static int playerGuess() {
        int guess;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the secret number (1-100): ");
        try {
            guess = scanner.nextInt();
        }catch (Exception e) {
            guess =  playerGuess();
        }
        if (guess < 1 || guess >100) {
            guess = playerGuess();
        }
        return guess;
    }//end guess()

    static int checkGuess(int secretNumber, int guess, int attempts) {
        if (guess > secretNumber) {
            System.out.println("Attempts: " + attempts);
            System.out.println("The secret number is lower than " + guess);
            attempts++;
        } else if (guess < secretNumber) {
            System.out.println("Attempts: " + attempts);
            System.out.println("The secret number is higher than " + guess);
            attempts++;
        } else {
            System.out.println("The secret number is " + guess);
            System.out.println("You win!!! Attempts: " + attempts);
            System.exit(0);
        }
        return attempts;
    }//end checkGuess()

}