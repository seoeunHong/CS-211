
/* Author: Seoeun Hong; Date: 10/4/2019;
 * Class: CS211; Project Name: ShoppingCart;
 * Description: This class stores information about the overall order;
 */
import java.util.ArrayList;

public class ShoppingCart {
	// class's private field for storing information of the shopping cart;
	private ArrayList<ItemOrder> orderList;
	private boolean checkDiscount;

	// Constructor of the ShoppingCart;
	// Sets initial value of private fields;
	public ShoppingCart() {
		ArrayList<ItemOrder> orderList = new ArrayList<ItemOrder>();
		this.orderList = orderList;
		checkDiscount = false;
	}

	// Add ordered item on the shopping cart list;
	// When add same item, it replace that item on the list with new order;
	// If add new item, it add that item end of the shopping list;
	public void add(ItemOrder itemOrder) {
		String newItem = itemOrder.getItem().name;
		for (int index = 0; index < orderList.size(); index++) {
			String oldItem = orderList.get(index).getItem().name;
			if (oldItem.equals(newItem)) {
				orderList.set(index, itemOrder);
				return;
			}
		}
		orderList.add(itemOrder);

	}

	// Decide provide discount or not
	public void setDiscount(boolean isDiscount) {
		checkDiscount = isDiscount;
	}

	// Return total cost of all items in the shopping cart;
	public double getTotal() {
		double total = 0;
		for (int index = 0; index < orderList.size(); index++) {
			total += orderList.get(index).getPrice();
		}
		if (checkDiscount) {
			return total * 0.9;
		} else {
			return total;
		}

	}
}
