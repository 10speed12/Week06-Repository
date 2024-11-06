package week06CodingProject;
import java.util.*;
public class Player {
	// LinkedList of Cards that stores current player hand:
	private List<Card> hand = new LinkedList<Card>();
	// Integer to store and track current player score:
	private int score;
	// String to store player name:
	private String name;
	// Default Constructor:
	Player(){
		score=0;
		name="";
	}
	// Constructor with a specified name value:
	Player(String iName){
		score=0;
		name=iName;
	}
	// Getter method for name:
	public String getName() {
		return name;
	}
	// Setter method for name:
	public void setName(String in) {
		name=in;
	}
	// Getter method for score:
	public int getScore() {
		return score;
	}
	// Method to increment score by 1 when called:
	public void incrementScore() {
		score++;
	}
	// Describe method that relays name and score of player to console, along with current hand contents:
	public void describe() {
		// Print out player name and score to console with println function:
		System.out.println(name+", current score: "+score);
		// Begin process of printing out contents of hand with prefaced information:
		System.out.println("Current hand contents: ");
		// Check to see if hand is currently empty:
		if(hand.isEmpty()) {
			// If hand currently has no items, report that detail to console with println:
			System.out.println("Hand is currently empty");
		}else {
			// Iterate through hand, reaching all but the last item in hand and call describe for each one,
			// followed by printing out a comma and space:
			for(int i=0;i<hand.size()-1;i++) {
				hand.get(i).describe();
				System.out.print(", ");
			}
			// Call describe function for last item in hand:
			hand.getLast().describe();
			// Perform println with empty arguments to have console exit to new line:
			System.out.println();
		}
	}
	// Function to draw a card from the top of a current deck, and add that card to the end of the list:
	public void draw(Deck deck) {
		// Call the draw function for given deck and store result in a temporary Card object:
		Card newCard = deck.draw();
		// Confirm that drawn card does not have a null value:
		if(newCard != null) {
			// If drawn card is not null, add it to hand:
			hand.add(newCard);
		}else {
			// If drawn card was null, report that no card could be added to user with an error message:
			System.out.println("Deck is empty, no card could be drawn.");
		}
	}
	// Flip function removes top card of hand and returns it:
	public Card flip() {
		try {
			// Call removeFirst function on hand and return result:
			return hand.removeFirst();
	
		}catch(Exception e) {
			// Denote that no cards are currently in hand and return null:
			System.out.println("Hand is presently empty.");
			return null;
		}
	}
}
