package week06CodingProject;

public class Card {
	private String name;
	private String suite;
	private int value;
	Card(){
		// Default Constructor
		name = "";
		suite = "";
		value = 0;
	}
	Card(String nameI, String suiteI, int valueI){
		// Constructor with explicit values:
		name = nameI;
		suite = suiteI;
		value = valueI;
	}
	public String getName() {
		// Getter function for name:
		return name;
	}
	public void setName(String nName) {
		// Setter function for name:
		name = nName;
	}
	public String getSuite() {
		// Getter function for suite:
		return suite;
	}
	public void setSuite(String nSuite) {
		// Setter function for suite:
		suite = nSuite;
	}
	public int getValue() {
		// Getter function for value:
		return value;
	}
	public void setValue(int nValue) {
		// Setter function for value:
		value = nValue;
	}
	public void describe() {
		// Function to print details of the card to the console:
		System.out.print(this.suite +" of "+this.name);
	}
}
