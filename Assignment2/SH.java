
/* Author: Seoeun Hong; Date: 09/27/2019;
 * Class: CS211; Project Name: SH;
 * Description: This subclass overrides Critter's methods for storing SH class's unique behavior;
 * */
import java.awt.Color;

//SH class is inherited the information from Critter class;
public class SH extends Critter {
	// Private fields that store data of this object;
	private final String FIRST_NAME = "Seoeun";
	private final String LAST_NAME = "Hong";
	private String shString;
	private int count;

	// Constructor of the critter SH;
	// Sets initial value of private fields;
	public SH() {
		this.shString = "S";
		this.count = 0;
	}

	// Returns movement behavior of the SH;
	// Movement behavior is different by condition;
	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}
		if (info.getFront() == Neighbor.WALL) {
			return Action.RIGHT;
		}
		if (info.getFront() == Neighbor.SAME) {
			return Action.LEFT;
		} else {
			return Action.HOP;
		}
	}

	// Return color of the SH;
	public Color getColor() {
		return Color.YELLOW;
	}

	// Return String value that is represented on console;
	// String value is presented differently by condition;
	public String toString() {
		// Reset count value as 0 to restart repeating behavior by every my full name's
		// length move;
		if (count == (FIRST_NAME.length() + LAST_NAME.length()))
			count = 0;
		// Return String value "S" until steps move by first name's length;
		if (count < FIRST_NAME.length()) {
			shString = "S";
			// Return String value "H" until steps move by last name's length;
		} else {
			shString = "H";
		}
		count++;

		return shString;
	}

}
