
/* Author: Seoeun Hong; Date: 10/4/2019;
 * Class: CS211; Project Name: Catalog;
 * Description: This class stores information about a collection of these items on one list;
 */
import java.util.ArrayList;

public class Catalog {
	// class's private field for storing information of list;
	private String name;
	private ArrayList<Item> catalogList;

	// Constructor of the catalog;
	// Sets initial value of private fields;
	public Catalog(String name) {
		this.name = name;
		catalogList = new ArrayList<Item>();
	}

	// Store Item class that has information of each items on list;
	public void add(Item item) {
		catalogList.add(item);
	}

	// Return size of this list;
	public int size() {
		return catalogList.size();
	}

	// Return Item class that has information of each items in list;
	public Item get(int index) {
		return catalogList.get(index);
	}

	// Return name of this list;
	public String getName() {
		return name;
	}
}