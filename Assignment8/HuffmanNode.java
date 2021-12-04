import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* Author: Seoeun Hong; Date: 11/22/2019;
 * Class: CS211; Class name: HuffmanNode;
 * Description: This class stores single node of HuffmanTree the data stored in node depends on whether it is leaf or branches
 * 				If this node works as branches, it stores left and right subtrees and if this node works as leaf, it stores assigned character and its frequency
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
	// Data field for storing each unique information of node
	public int frequency = 0;
	public char character = 0;
	public HuffmanNode left = null;
	public HuffmanNode right = null;

	// Constructor for making leaf node
	public HuffmanNode(char character, int frequency) {
		this.character = character;
		this.frequency = frequency;
	}

	// Constructor for making branch node
	public HuffmanNode(HuffmanNode left, HuffmanNode right) {
		frequency = left.frequency + right.frequency;
		this.left = left;
		this.right = right;
	}

	// Test whether this node is leaf or not and return boolean value as a result
	public boolean isLeaf() {
		return (left == null && right == null);
	}

	// Accept FileInputStream value as a parameter and return Map<Character,Integer>
	// value that stores character as a key and its frequency in the file as a
	// value;
	public static Map<Character, Integer> getCounts(FileInputStream input) throws IOException {
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		int asciiValue;
		do {
			// read each ASCII data from the input
			asciiValue = input.read();
			// Cast ASCII value with char to store data as char type
			char charValue = (char) asciiValue;
			// Check data is already detected and stored
			Integer frequency = charCount.get(charValue);
			if (frequency == null)
				charCount.put(charValue, 1);
			else
				charCount.put(charValue, frequency + 1);
		} while (asciiValue > 0);
		// Stop while loop after when this loop works on with EOF value
		// Binary value of eof is -1
		return charCount;

	}

	// Set HuffmanNode would be sorted out with frequency order(from low to high
	// frequency)
	public int compareTo(HuffmanNode o) {
		return frequency - o.frequency;
	}
}
