package week06Lab;

import java.util.Arrays;

public class GameBoard {
	// Declare a String array to serve as storage for gameboard state:
	private String[] gameBoard;
	// Boolean flag to signify a draw:
	private boolean isDraw;
	// Constructor Method:
	GameBoard(){
		// Set gameBoard as an array with a length of nine elements:
		gameBoard=new String[9];
		// Fill gameBoard with single space strings using Arrays.fill():
		Arrays.fill(gameBoard," ");
		// Set isDraw to false:
		isDraw=false;
	}
	/* 
	 Function to adjust value in gameBoard at a given index, with regards to current turn number, 
	 and return a boolean value to signify if given index was altered:
	 */
	public boolean setIndex(int index, int turnNumber) {
		try {
			// Check to see that given index is not already occupied:
			if(gameBoard[index].equals(" ")) {
				// If given index is not already used, set given index according to turnNumber%2:
				if(turnNumber%2==0) {
					// If turn number is even, place an "O" in current index:
					gameBoard[index]="O";
				}else {
					// If turn number is odd, place an "X" in current index:
					gameBoard[index]="X";
				}
				return true;
			}else {
				// If given index is already occupied, print an error message to console and return false:
				System.out.println("Error. Inputted index has already been used. Try again.");
				return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			// If an index beyond the scope of gameBoard, i.e. a value less than 0 or greater than 8,
			// was entered, print an error message to console and return false:
			System.out.println("Error. Inputted index must be an integer between 0 and 8, inclusive. Try again.");
			return false;
		}
	}
	// Function to determine if a player has won or if game ended in a draw:
	public boolean checkWinStatus(int turnNumber) {
		// Set a String to determine what value to look for depending on current turn number:
		String turnChar="";
		if(turnNumber%2==0) {
			// If current turn number is even, set turnChar to "O":
			turnChar="O";
		}else{
			// If current turn number is odd, set turnChar to "X":
			turnChar="X";
		}
		// Check horizontal rows for turnChar matches:
		if(checkWinHorizontal(turnChar)) {
			// If a horizontal line of 3 turnChar items was found, print out a win message to console
			// and return true:
			if(turnChar == "X") {
				System.out.println("Player 1 has won!");
			}else {
				System.out.println("Player 2 has won!");
			}
			return true;
		}
		// Check vertical columns for turnChar matches:
		if(checkWinVertical(turnChar)) {
			// If a vertical line of 3 turnChar items was found, print out a win message to console
			// and return true:
			if(turnChar == "X") {
				System.out.println("Player 1 has won!");
			}else {
				System.out.println("Player 2 has won!");
			}
			return true;
		}
		// Check diagonals for turnChar matches:
		if(checkWinDiagonal(turnChar)) {
			// If a diagonal line of 3 turnChar items was found, print out a win message to console
			// and return true:
			if(turnChar == "X") {
				System.out.println("Player 1 has won!");
			}else {
				System.out.println("Player 2 has won!");
			}
			return true;
		}
		// If all other win conditions failed, and turnNumber=9, print a message signifying a draw to console and return
		// true:
		if(turnNumber == 9) {
			System.out.println("All spaces filled. Game has ended in a draw");
			// Set isDraw to true:
			isDraw=true;
			return true;
		}
		return false;
	}
	// Function to check horizontal rows for win conditions:
	private boolean checkWinHorizontal(String val) {
		// Check to see if each value in gameBoard for 3 consecutive indexes match entered String:
		for(int i=0;i<9;i+=3) {
			if(gameBoard[i].equals(val) && gameBoard[i+1].equals(val) && gameBoard[i+2].equals(val)) {
				// If all items in a row, signified by 3 consecutive indexes, match, return true:
				return true;
			}
		}
		// Return false if no matching row was found:
		return false;
	}
	// Function to check vertical columns for win conditions:
	private boolean checkWinVertical(String val) {
		// Check to see if each value in gameBoard for 3 consecutive indexes i,i+3, and i+6 match entered string:
		for(int i=0;i<3;i++) {
			if(gameBoard[i].equals(val) && gameBoard[i+3].equals(val) && gameBoard[i+6].equals(val)) {
				// If all items in a column, signified as a series i, i+3, and i+6, match entered string, return true:
				return true;
			}
		}
		// Return false if no vertical column of val was found:
		return false;
	}
	// Function to check for diagonal win conditions:
	private boolean checkWinDiagonal(String val) {
		// Check to see if value at index 4 matches entered string, as both diagonals pass through there:
		if(gameBoard[4].equals(val)) {
			// Check to see if either the values at indexes 0 and 8 both match val,
			// or that the values at indexes 2 and 6 both match val:
			if( (gameBoard[0].equals(val) && gameBoard[8].equals(val)) || 
					(gameBoard[2].equals(val) && gameBoard[6].equals(val)) ) {
				// If a diagonal line of 3 items of value val was found, return true:
				return true;
			}else {
				// Return false if no winning diagonal was found:
				return false;
			}
		}else { 
			// Return false if value at index 4 doesn't match, as no diagonal can be made:
			return false;
		}
	}
	// Getter method for isDraw:
	public boolean checkDraw() {
		return isDraw;
	}
	// Method to reset board if players wish to go another round:
	public void reset() {
		// Reset gameBoard with empty spaces at each index:
		Arrays.fill(gameBoard, " ");
		// Set isDraw to false:
		isDraw=false;
	}
	// Function to display current state of board:
	public void display() {
		// Set up pointer to indicate current row to be printed:
		int index=0;
		for(int i=0;i<3;i++) {
			// Place a top border of dashes above current row:
			System.out.println("--------------");
			// Print gameBoard[index+i] and gameBoard[index+i+1] to console with print,
			// and println for gameBoard[index+i+2];
			System.out.print("| "+ gameBoard[index+i]);
			System.out.print(" | " + gameBoard[index+i+1]);
			System.out.println(" | "+gameBoard[index+i+2]+" |");
			// Increment index by 2:
			index+=2;
		}
		// Place a bottom border beneath the last row:
		System.out.println("--------------");
		System.out.println();
	}
}
