import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* Author: Seoeun Hong; Date: 11/08/2019;
 * Class: CS211; Project Name: Assignment6;
 * Description: Practice to use Stack and Queue's character to analyze the numbers;
 * */

public class Assignment6 {

	public static void main(String[] args) {
		testSeeingThreeMethod();
		testTwoStacksAreEqualMethod();
		testIsMirrored();
	}

	public static void seeingThree(Stack<Integer> s) {
		// Declare a queue for auxiliary storage;
		Queue<Integer> temp = new LinkedList<Integer>();
		// Store all data stored in Stack s to the Queue;
		while (!s.isEmpty()) {
			temp.add(s.pop());
		}
		// Store all data stored in Queue temp to the Stack with multiplying triple
		// times for each number;
		while (!temp.isEmpty()) {
			int number = temp.remove();
			for (int multiple = 1; multiple <= 3; multiple++) {
				s.push(number);
			}
		}
		// For reordering the numbers, store data stored in Stack s to the Queue;
		while (!s.isEmpty()) {
			temp.add(s.pop());
		}
		// Store again form temp to s;
		while (!temp.isEmpty()) {
			s.add(temp.remove());
		}
	}

	public static boolean twoStacksAreEqual(Stack<Integer> s1, Stack<Integer> s2) {
		// Return false when two stack size is different;
		if (s1.size() != s2.size()) {
			return false;
		} else {
			// Set basic boolean value as true;
			boolean same = true;
			// Declare a Stack for auxiliary storage;
			Stack<Integer> temp = new Stack<Integer>();
			// Analyze all number in both stack until stacks are empty or number in same
			// order is different;
			while (same && !s1.isEmpty()) {
				int num1 = s1.pop();
				int num2 = s2.pop();
				if (num1 != num2)
					same = false;
				// Store numbers which are taken out from the each stack to temp;
				temp.push(num1);
				temp.push(num2);
			}
			// Put numbers in temp back to each stack;
			while (!temp.isEmpty()) {
				s2.push(temp.pop());
				s1.push(temp.pop());
			}
			// Return whether the two stack are equal;
			return same;
		}

	}

	public static boolean isMirrored(Queue<Integer> q) {
		// Return true value when the Queue is empty;
		if (q.isEmpty()) {
			return true;
		} else {
			Stack<Integer> temp = new Stack<Integer>();
			int size = q.size();
			int halfSize = size / 2;
			boolean same = true;
			for (int order = 1; order <= size; order++) {
				int number = q.remove();
				// Store first half of the numbers of the q to Stack value temp;
				if (order <= halfSize) {
					temp.push(number);
					// When numbers in q is odd, put the middle number which doesn't have to be
					// analyzed end of the q;
				} else if (size % 2 != 0 && order == halfSize + 1) {
					q.add(number);
					continue;
				} else {
					// Compare last half of the numbers of the q with its first half which is
					// stored on the temp;
					int testNum = temp.pop();
					if (number != testNum)
						// Switch same value to false if the q does not have mirrored numbers;
						same = false;
				}
				// Put analyzed number at the end of the q for keeping data;
				q.add(number);
			}
			return same;
		}
	}

	private static void testIsMirrored() {
		Queue<Integer> myQueueP = new LinkedList<Integer>();
		;
		for (int i = 0; i < 5; i++) {
			System.out.print(i);
			myQueueP.add(i);
		}

		for (int i = 3; i >= 0; i--) {
			System.out.print(i);
			myQueueP.add(i);
		}
		System.out.println();
		System.out.println(isMirrored(myQueueP) + " isMirrord");
	}

	private static void testTwoStacksAreEqualMethod() {
		Stack<Integer> myStack1 = new Stack<Integer>();
		Stack<Integer> myStack2 = new Stack<Integer>();
		Stack<Integer> myStack3 = new Stack<Integer>();
		Stack<Integer> myStack4 = new Stack<Integer>();
		for (int i = 0; i < 5; i++) {
			myStack1.push(i);
			myStack2.push(i);
			myStack4.push(i);
		}
		for (int i = 0; i < 6; i++) {
			myStack3.push(i);
		}

		System.out.println(twoStacksAreEqual(myStack1, myStack2) + " Same Stack ");
		System.out.println(twoStacksAreEqual(myStack3, myStack4) + " Not Same Stack");
	}

	private static void testSeeingThreeMethod() {
		Stack<Integer> myStack = new Stack<Integer>();
		for (int i = 0; i < 5; i++) {
			myStack.push(i);
		}
		System.out.println();
		print(myStack);
		seeingThree(myStack);
		print(myStack);
	}

	private static void print(Stack<Integer> s) {
		Enumeration<Integer> e = s.elements();
		while (e.hasMoreElements())
			System.out.print(e.nextElement() + " ");
		System.out.println();
	}
} // end of Assignment6