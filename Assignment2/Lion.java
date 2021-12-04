
/* Author: Seoeun Hong; Date: 09/27/2019;
 * Class: CS211; Project Name: Lion;
 * Description: This subclass overrides Critter's methods for storing Lion class's unique behavior;
 * */
import java.awt.Color;

//Lion class is inherited the information from Critter class;
public class Lion extends Critter {
	// Private fields that store data of this object;
	private int numberOfMove;
	private Color lionColor;
	// Lion class repeats color chaining every 3 moves;
	private final int COLOR_CHANGED = 3;

	// Constructor of the critter Lion;
	// Sets initial value of private fields;
	public Lion() {
		this.numberOfMove = 0;
	}
	// Returns movement behavior of the Lion;
	// Movement behavior is different by condition;

	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}
		if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		}
		if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		} else {
			return Action.HOP;
		}
	}

	// Return color of the Lion;
	// Color of Lion is selected randomly among three colors and changed by
	// condition;
	public Color getColor() {
		// Divide by COLOR_CHANGED value since color changing is repeated every 3 moves;
		if (numberOfMove % COLOR_CHANGED == 0) {
			int randomColor = (int) (Math.random() * 3);
			if (randomColor == 0) {
				lionColor = Color.RED;
			} else if (randomColor == 1) {
				lionColor = Color.GREEN;
			} else {
				lionColor = Color.BLUE;
			}
		}
		numberOfMove++;
		return lionColor;
	}

	// Return String value that is represented on console;
	public String toString() {
		return "L";
	}

}
