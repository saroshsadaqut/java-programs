import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int difficultyLevel = chooseDifficulty();
        int minRange = 1, maxRange = 0;

        switch (difficultyLevel) {
            case 1: // Easy
                maxRange = 10;
                break;
            case 2: // Medium
                maxRange = 100;
                break;
            case 3: // Hard
                maxRange = 1000;
                break;
        }

        int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int attempts = 0;

        System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");

        while (true) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Low! Try again.");
            } else {
                System.out.println("High! Try again.");
            }
        }
        sc.close();
    }

    private static int chooseDifficulty() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }
}