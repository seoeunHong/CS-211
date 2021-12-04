/* Author: Seoeun Hong; Date: 09/27/2019;
 * Class: CS211; Project Name: Bear;
 * Description: This subclass overrides Critter's methods for storing Bear class's unique behavior;
 * */
import java.awt.Color;

//Bear class is inherited the information from Critter class;
public class Bear extends Critter {
	// Private fields that store data of this object;
	private boolean polar;
	private int numberOfMove;

	// Constructor of the critter Bear
	// Hold boolean as parameter and set the initial value of field;
	public Bear(boolean polar) {
		this.polar = polar;
		this.numberOfMove = 0;
	}

	// Returns movement behavior of the Bear;
	// Movement behavior is different by condition;
	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}
		if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		} else {
			return Action.LEFT;
		}
	}

	// Return color of the Bear;
	// Color is different by the parameter that this object got;
	public Color getColor() {
		if (polar) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}

	// Return String value that is represented on console;
	// String value is presented differently by condition;
	public String toString() {
		if (numberOfMove % 2 == 0) {
			numberOfMove++;
			return "/";
		} else {
			numberOfMove++;
			return "\\";
		}
	}

}
