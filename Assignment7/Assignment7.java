/* Author: Seoeun Hong; Date: 11/08/2019;
 * Class: CS211; Class name: ArrayIntList;
 * Description: This class tests three method upToNowTotal(), isPairSorted(), and removeLast(int n) 
 * to check it works well;
 * */
public class Assignment7 {
	public static void main(String[] args) {
		testUpToNowTotal();
		System.out.println("------------------------------------");
		testIsPairSorted();
		System.out.println("------------------------------------");
		testRemoveLast();
	}

	public static void testUpToNowTotal() {
		// make a demo ArrayIntList to test the method
		ArrayIntList list = new ArrayIntList(2, 3, 5, 4, 7, 15, 20, 7);
		System.out.println("[Trial 1 for upToNowTotal()]");
		// show origin ArrayIntList value for the user
		System.out.println("Default value of ArrayIntList: " + list);
		// run upToNowTotal() method of the list and take the new ArrayIntList value
		// from the method
		ArrayIntList list2 = list.upToNowTotal();
		// show new ArrayIntList value that upToNowTotal() method returns to the user
		System.out.println("Returnnig value of upToNowTotal() method: " + list2);
		System.out.println();

		ArrayIntList list3 = new ArrayIntList(1, -2, 3, -4, 5, -6, 7, -8, 9, -10, 11);
		System.out.println("[Trial 2 for upToNowTotal()]");
		System.out.println("Default value of ArrayIntList: " + list3);
		ArrayIntList list4 = list3.upToNowTotal();
		System.out.println("Returnnig value of upToNowTotal(): " + list4);
		System.out.println();

		ArrayIntList list5 = new ArrayIntList();
		for (int number = -5; number <= 5; number++) {
			list5.add(number);
		}
		System.out.println("[Trial 3 for upToNowTotal()]");
		System.out.println("Default value of ArrayIntList: " + list5);
		ArrayIntList list6 = list5.upToNowTotal();
		System.out.println("Returnnig value of upToNowTotal(): " + list6);
		System.out.println();

	}

	public static void testIsPairSorted() {
		ArrayIntList list = new ArrayIntList(3, 8, 2, 5, 19, 24, -3, 0, 4, 4, 8, 205, 42);
		System.out.println("[Trial 1 for isPairSorted()]");
		// show origin ArrayIntList value for the user
		System.out.println("Default value of ArrayIntList: " + list);
		// run isPairSorted() method of the list and show boolean value that method
		// returns to the user
		System.out.println("Is a list of integers pairwise sorted? " + list.isPairSorted());
		System.out.println();

		ArrayIntList list2 = new ArrayIntList(1, 9, 3, 17, 4, 28, -5, -3, 0, 42, 308, 409, 19, 17, 2, 4);
		System.out.println("[Trial 2 for isPairSorted()]");
		System.out.println("Default value of ArrayIntList: " + list2);
		System.out.println("Is a list of integers pairwise sorted? " + list2.isPairSorted());
		System.out.println();

		ArrayIntList list3 = new ArrayIntList();
		System.out.println("[Trial 3 for isPairSorted()]");
		System.out.println("Default value of ArrayIntList: " + list3);
		System.out.println("Is a list of integers pairwise sorted? " + list3.isPairSorted());
		System.out.println();

		ArrayIntList list4 = new ArrayIntList(1);
		System.out.println("[Trial 4 for isPairSorted()]");
		System.out.println("Default value of ArrayIntList: " + list4);
		System.out.println("Is a list of integers pairwise sorted? " + list4.isPairSorted());
		System.out.println();

	}

	public static void testRemoveLast() {
		ArrayIntList list = new ArrayIntList(8, 17, 9, 24, 42, 3, 8);
		System.out.println("[Trial 1 for removeLast(int n)]");
		// show origin ArrayIntList value for the user
		System.out.println("Default value of ArrayIntList: " + list);
		// run removeLast() method of the list
		list.removeLast(4);
		// show changed list value for the user
		System.out.println("List value after running removeLast(4): " + list);
		list.removeLast(0);
		System.out.println("List value after running removeLast(0): " + list);
		list.removeLast(list.size());
		System.out.println("List value after running removeLast(list.size()): " + list);
		System.out.println();

		ArrayIntList list2 = new ArrayIntList(1, 3, 5, 6, 7, 8);
		System.out.println("[Trial 2 for removeLast(int n)]");
		System.out.println("Default value of ArrayIntList: " + list2);
		System.out.println();
		System.out.println("---------call removeList(-2)---------");
		System.out.println();
		list.removeLast(-2);
		System.out.println();
		System.out.println("List value after running: " + list2);
		System.out.println();
		System.out.println("---------call removeList(list2.size()+1)---------");
		System.out.println();
		list.removeLast(list2.size() + 1);
		System.out.println();
		System.out.println("List value after running: " + list2);
		System.out.println();
	}

}
