package week06CodingProject;

import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Storage for current game number:
		int gameNumber=1;
		// Storage for player1 wins:
		int p1Wins=0;
		// Storage for player2 wins:
		int p2Wins=0;
		// Play a round of war and return an integer based on results:
		int result = play(gameNumber);
		if(result==1) {
			p1Wins++;
		}else if(result==2) {
			p2Wins++;
		}else {
			System.out.println("Game ended in a draw with equal points on both sides.");
		}
		// Create a scanner object to receive user input:
		Scanner scanner=new Scanner(System.in);
		// Boolean flag for continues:
		boolean continues=false;
		// Set up repeat functionality:
		System.out.println("Play again? Enter y for yes, or n for no:");
		// Receive input for re-playing the game:
		String input = scanner.nextLine();
		while(!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
			System.out.println("Invalid input entered. Enter y for yes or n for no: ");
			input=scanner.nextLine();
		}
		if(input.equalsIgnoreCase("Y")) {
			continues=true;
		}else {
			continues=false;
		}
		// Repeat as long as continues remains to be set to true:
		while(continues) {
			// Increment gameNumber:
			gameNumber++;
			// Play a round of war and return an integer based on results:
			result = play(gameNumber);
			if(result==1) {
				p1Wins++;
			}else if(result==2) {
				p2Wins++;
			}else {
				System.out.println("Game ended in a draw with equal points on both sides.");
			}
			// Report current win records to console:
			System.out.println("Player 1 has won "+p1Wins+" games and Player 2 has won "+p2Wins + "games, with "
					+gameNumber+" games played overall and "+(gameNumber-(p1Wins+p2Wins))+ "draws occurring.");
			// Set up repeat functionality:
			System.out.println("Play again? Enter y for yes, or n for no:");
			// Receive input for re-playing the game:
			input = scanner.nextLine();
			while(!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
				// Confirm valid input and repeat until valid input is entered:
				System.out.println("Invalid input entered. Enter y for yes or n for no: ");
				input=scanner.nextLine();
			}
			if(input.equalsIgnoreCase("Y")) {
				// If 'y' was entered, set continues flag to true:
				continues=true;
			}else {
				// If 'n' was entered, set continues flag to false:
				continues=false;
			}
		}
		// Close scanner and report game over message to console:
		scanner.close();
		System.out.println("Program ended.");
	}
	// Automating play functionality in a separate function for repeat functionality:
	public static int play(int gameNumber) {
		System.out.println("Starting game:"+gameNumber);
		// Create a new deck:
		Deck deck = new Deck();
		// Create players 1 and 2, with names of Player1 and Player2:
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		// Shuffle the deck:
		deck.shuffle();
		// For-loop to draw cards from the deck, alternating between players:
		for(int i=0; i < 52; i++) {
			// If i is even, player 1 draws, otherwise player 2 draws:
			if(i%2 == 0) {
				p1.draw(deck);
			}else {
				p2.draw(deck);
			}
		}
		// Call describe functions on both players:
		p1.describe();
		p2.describe();
		// Iterate 26 times to simulate game:
		for(int i=0;i < 26; i++) {
			// Obtain and store the cards obtained by flipping each player:
			Card p1Card = p1.flip();
			Card p2Card = p2.flip();
			// Confirm that neither p1Card or p2Card are null:
			if(p1Card == null || p2Card == null) {
				// If either card was null, report an error message and exit loop early:
				System.out.println("One of the cards was a phantom value. Exiting loop.");
				break;
			}
			// Report details of each card to console:
			p1Card.describe();
			System.out.print(" vs. ");
			p2Card.describe();
			System.out.println();
			// Compare the values of p1Card and p2Card:
			if(p1Card.getValue()>p2Card.getValue()) {
				// If p1Card has a higher value, increment p1's score:
				p1.incrementScore();
			}else if(p2Card.getValue()>p1Card.getValue()) {
				// If p2Card has a higher value, increment p2's score:
				p2.incrementScore();
			}else {
				// If the values are equal, print draw message to user:
				System.out.println("Both cards have equal value. Draw ensues with no point gain to either side.");
			}
			// Print current score values to console:
			System.out.println("Current Scores: ");
			System.out.println("Player 1: "+p1.getScore()+" and Player 2: "+p2.getScore());
		}
		// Compare player scores:
		if(p1.getScore()>p2.getScore()) {
			// If player 1 has the higher score, return 1 along with win message:
			System.out.println("Player 1 wins with a score of "+p1.getScore());
			return 1;
		} else if(p2.getScore()>p1.getScore()) {
			// If player 2 has the higher score, return 2 along with win message:
			System.out.println("Player 2 wins with a score of "+p2.getScore());
			return 2;
		}else {
			// If the scores are even, return 0:
			return 0;
		}
	}
}
