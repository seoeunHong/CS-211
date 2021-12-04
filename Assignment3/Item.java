
/* Author: Seoeun Hong; Date: 10/4/2019;
 * Class: CS211; Project Name: Item;
 * Description: This class stores each items' unique information;
 */
import java.text.NumberFormat;

public class Item {
	// class's field for storing information of item;
	public final String name;
	private double price;
	private int bulkQuantity;
	private double bulkPrice;

	// Constructor of Item that does not offer bulk discount;
	// Call another constructor that has String, double, int, and double as a
	// parameter;
	public Item(String name, double price) {
		this(name, price, 0, 0);
	}

	// Constructor of Item that offers bulk discount;
	// Set the initial value of field with parameter value;
	public Item(String name, double price, int bulkQuantity, double bulkPrice) {
		// throw exception for invalid information of Item;
		if (price < 0 || bulkQuantity < 0 || bulkPrice < 0) {
			throw new IllegalArgumentException();
		} else {
			this.name = name;
			this.price = price;
			this.bulkQuantity = bulkQuantity;
			this.bulkPrice = bulkPrice;
		}
	}

	// Return user's total price for this specific item;
	// Total price is different by quantity which is a user-input;
	public double priceFor(int quantity) {
		// throw exception for invalid user-input
		if (quantity < 0) {
			throw new IllegalArgumentException();
			// Calculate total price for item which offers bulk discount;
		} else if (bulkQuantity != 0) {
			int numberOfBulk = quantity / bulkQuantity;
			double bulkValue = numberOfBulk * bulkPrice;
			double singleValue = price * (quantity % bulkQuantity);
			return bulkValue + singleValue;
			// Calculate total price for item which does not offer bulk discount;
		} else {
			return quantity * price;
		}
	}

	// Return String value that is represented on console;
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String finalValue = name + ", " + nf.format(price);
		// Add when this item offer bulk discount;
		if (bulkQuantity != 0 && bulkPrice != 0) {
			return finalValue += " (" + bulkQuantity + " for " + nf.format(bulkPrice) + ")";
		} else {
			return finalValue;
		}
	}

}
