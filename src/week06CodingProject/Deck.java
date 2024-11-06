package week06CodingProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// Private array of the suite names initialized to speed up deck construction:
	private String[] suites = {"Clubs","Spades","Hearts","Diamonds"};
	// Private array of card values initialized to speed up deck construction:
	private String[] numbers = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
			"Jack","Queen","King","Ace"};
	// ArrayList of Cards to store all the cards in the deck:
	private List<Card> cards = new ArrayList<Card>();
	// Constructor for class:
	Deck(){
		// Initialize a for loop to iterate through suites:
		for(int i = 0; i < 4; i++) {
			// Initialize a for loop to iterate through the contents of numbers:
			for(int j=0; j < numbers.length; j++) {
				// Create a card with current suite, current name in numbers, and a value of j+2:
				Card temp = new Card(suites[i],numbers[j],j+2);
				// Add new card to cards list:
				cards.add(temp);
			}
		}	
	}
	// Getter function to access cards list:
	public List<Card> getCards(){
		return cards;
	}
	// Setter function for cards:
	public void setCards(List<Card> nDeck) {
		cards = nDeck;
	}
	// Describe function to print out contents of current deck to console:
	public void describe() {
		// Use a for-loop to go through contents of cards:
		for(Card current: cards) {
			// Call describe function for current card:
			current.describe();
		}
	}
	// Function to shuffle contents of current deck:
	public void shuffle() {
		// Call Collections built-in shuffle function to shuffle cards list:
		Collections.shuffle(cards);
	}
	// Function to draw a card from the deck:
	public Card draw() {
		// Check to see if there are still cards in the deck:
		if(!cards.isEmpty()) {
			// Return card at the head of the list and remove that card from the list with the removeFirst() function:
			return cards.removeFirst();
		} else {
			return null;
		}
	}
}
