
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rnd = new Random();
        Scanner input = new Scanner(System.in);

        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")
                || playAgain.equalsIgnoreCase("y")) {

            System.out.println("\n=== Welcome to the Craps Game ===");

            // Roll two dice for the first time
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;

            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + crapsRoll);

            int point = 0;

            // Check the initial roll
            if (crapsRoll == 2 || crapsRoll == 3
                    || crapsRoll == 12) {

                System.out.println("Craps! You lost.");

            } else if (crapsRoll == 7 || crapsRoll == 11) {

                System.out.println("Natural! You won.");

            } else {

                // Establish the point
                point = crapsRoll;
                System.out.println("The point is " + point);
                System.out.println("Trying for point...");

                boolean gameOver = false;

                // Continue rolling until the player wins or loses
                while (!gameOver) {

                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;

                    System.out.println("\nDie 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + crapsRoll);

                    if (crapsRoll == point) {

                        System.out.println("Made point and won!");
                        gameOver = true;

                    } else if (crapsRoll == 7) {

                        System.out.println("Got a seven and lost!");
                        gameOver = true;

                    } else {

                        System.out.println("Trying for point...");
                    }
                }
            }

            // Ask whether to start another game
            System.out.print("\nWould you like to play again? (yes/no): ");
            playAgain = input.nextLine().trim();
        }

        System.out.println("Thanks for playing Craps!");
        input.close();
    }
}
