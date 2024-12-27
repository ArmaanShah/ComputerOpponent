
/*
 * RockPaperScissors.java
 * Author:  Armaan Shah
 * Submission Date: October 4rd 2024
 *
 *This program does the following:
 *Based on how many points the user wants to play till, the computer will play rock paper scissors, 
 *against the user. The user will input either "rock", "paper", or "scissors" and when testing mode is false, 
 *the computer will randomly select one of the 3. The points are tracked after each round and the game continues until, 
 *there is a winner. 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither 
 * received nor given inappropriate assistance. I have not copied 
 * or modified code from any source other than the course webpage 
 * or the course textbook. I recognize that any unauthorized 
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the 
 * policies of this course. I recognize that my work is based 
 * on an assignment created by the School of Computing 
 * at the University of Georgia. Any publishing or
 * posting of source code for this assignment is strictly 
 * prohibited unless you have written consent from the 
 * School of Computing at the University of Georgia.  
 */
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Points to win: ");
		int pointsToWin = scanner.nextInt();
		scanner.nextLine();

		int playerScore = 0;
		int computerScore = 0;

		while (playerScore < pointsToWin && computerScore < pointsToWin) {
			String playerMove = "";
			boolean validInput = false;

			// Loop until valid input is received
			while (!validInput) {
				System.out.print("Rock, paper, or scissors? ");
				playerMove = scanner.nextLine().trim().toLowerCase();

				if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")) {
					validInput = true;
				}
			}

			// Retrieves the computer move from ComputerOpponent
			String computerMove = ComputerOpponent.getMove();

			// Sets conditions for winning each round
			if (playerMove.equals(computerMove)) {
				System.out.println(", so it's a tie. (" + playerScore + "-" + computerScore + ")");
			} else if ((playerMove.equals("rock") && computerMove.equals("scissors"))
					|| (playerMove.equals("paper") && computerMove.equals("rock"))
					|| (playerMove.equals("scissors") && computerMove.equals("paper"))) {
				playerScore++;
				System.out.println(", so you win! (" + playerScore + "-" + computerScore + ")");
			} else {
				computerScore++;
				System.out.println(", so you lose. (" + playerScore + "-" + computerScore + ")");
			}
		}

		// Final result
		if (playerScore == pointsToWin) {
			System.out.println("Congratulations! You won!");
		} else if (computerScore == pointsToWin) {
			System.out.println("Sorry, you lost. Better luck next time!");
		}

		scanner.close();

	}
}