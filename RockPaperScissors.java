import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0, computerScore = 0;

        while (true) {
            System.out.println("Choose your move: (rock, paper, scissors)");
            String userChoice = scanner.nextLine().toLowerCase();

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                continue;
            }

            int computerChoice = random.nextInt(3);
            String computerChoiceString = "";
            switch (computerChoice) {
                case 0:
                    computerChoiceString = "rock";
                    break;
                case 1:
                    computerChoiceString = "paper";
                    break;
                case 2:
                    computerChoiceString = "scissors";
                    break;
            }

            System.out.println("Computer chose: " + computerChoiceString);

            if (userChoice.equals(computerChoiceString)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoiceString.equals("scissors")) ||
                       (userChoice.equals("paper") && computerChoiceString.equals("rock")) ||
                       (userChoice.equals("scissors") && computerChoiceString.equals("paper"))) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("Computer wins!");
                computerScore++;
            }

            System.out.println("Score: You: " + userScore + " | Computer: " + computerScore);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        scanner.close();
    }
}