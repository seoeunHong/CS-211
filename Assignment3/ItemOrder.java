/* Author: Seoeun Hong; Date: 10/4/2019;
 * Class: CS211; Project Name: ItemOrder;
 * Description: This class stores information about a particular item and the quantity ordered for that item; 
 */
public class ItemOrder {
	// class's field for storing information of ordered items;
	public final Item item;
	public final int quantity;

	// Constructor of the ItemOrder;
	// Sets initial value of fields;
	public ItemOrder(Item item, int quantity) {
		// throw exception for invalid information for quantity;
		if (quantity < 0) {
			throw new IllegalArgumentException();
		} else {
			this.item = item;
			this.quantity = quantity;
		}
	}

	// Return user's total price for this item;
	// Total price is different by quantity which is a user input;
	public double getPrice() {
		return item.priceFor(quantity);
	}

	// Return information of this item;
	public Item getItem() {
		return item;
	}

}
