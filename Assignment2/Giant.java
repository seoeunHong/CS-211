
/* Author: Seoeun Hong; Date: 09/27/2019;
 * Class: CS211; Project Name: Giant;
 * Description: This subclass overrides Critter's methods for storing Giant class's unique behavior;
 * */
import java.awt.Color;

//Giant class is inherited the information from Critter class;
public class Giant extends Critter {
	// Private fields that store data of this object;
	private int numberOfMove;
	private int count;
	private String giantString;
	// Giant class holding same String value for 6 moves;
	private final int KEEPING_TOSTRING = 6;
	// Giant class repeats same String value chaining behavior every 24 moves;
	private final int REPEATING = 24;

	// Constructor of the critter Giant;
	// Sets initial value of private fields;
	public Giant() {
		this.numberOfMove = 0;
		this.count = 0;
		this.giantString = "fee";
	}

	// Returns movement behavior of the Giant;
	// Movement behavior is different by condition;
	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}
		if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		} else {
			return Action.RIGHT;
		}
	}

	// Return color of the Giant;
	public Color getColor() {
		return Color.GRAY;
	}

	// Return String value that is represented on console;
	// String value is presented differently by condition;
	public String toString() {
		// Divide by REAPEATING value since changing behavior is repeated every 24
		// moves;
		if (numberOfMove % REPEATING == 0)
			// Reset count value as 0 to restart repeating behavior;
			count = 0;
		// Return each unique String value for each 6 moves;
		if (count / KEEPING_TOSTRING == 0) {
			giantString = "fee";
		} else if (count / KEEPING_TOSTRING == 1) {
			giantString = "fie";
		} else if (count / KEEPING_TOSTRING == 2) {
			giantString = "foe";
		} else {
			giantString = "fum";
		}

		numberOfMove++;
		count++;
		return giantString;
	}

}
