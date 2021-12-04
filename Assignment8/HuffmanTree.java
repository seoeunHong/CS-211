import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/* Author: Seoeun Hong; Date: 11/22/2019;
 * Class: CS211; Class name: HuffmanTree;
 * Description: This class construct HuffmanTree. Assign unique byte for each character according its frequency
 * 				Compress and decompress input file data and also print HuffmanTree in side ways 
 */
public class HuffmanTree {
	// Data field for storing each unique information of HuffmanTree
	HuffmanNode overallRoot = null;
	Map<Character, String> HuffmanCode = new HashMap<Character, String>();
	StringBuilder strInfor = new StringBuilder();

	// This constructor takes Map<Character, Integer> value that stores character as
	// a key and its frequency in the file as parameter, constructs HuffmanTree, and
	// assign its unique byte
	public HuffmanTree(Map<Character, Integer> counts) {

		Queue<HuffmanNode> charQueue = new PriorityQueue<HuffmanNode>();
		for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
			charQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
		}
		// Make a HuffmanTree
		while (charQueue.size() > 1) {
			HuffmanNode leftNode = charQueue.poll();
			HuffmanNode rightNode = charQueue.poll();
			charQueue.add(new HuffmanNode(leftNode, rightNode));
		}
		// Store HoffmanTree to data field
		overallRoot = charQueue.poll();
		// Call assignHuffmanCode method for assigning Huffman Code for each character
		assignHuffmanCode(overallRoot, HuffmanCode, "");

	}

	// Assign Huffman code depending the their leaf node location in the HuffmanTree
	public void assignHuffmanCode(HuffmanNode root, Map<Character, String> stor, String code) {
		if (root.isLeaf()) {
			stor.put(root.character, code);
		} else {
			assignHuffmanCode(root.left, stor, code + "0");
			assignHuffmanCode(root.right, stor, code + "1");
		}
	}

	// Compress input file original data to HuffmanCode
	public StringBuilder compress(InputStream inputFile) throws IOException {
		StringBuilder result = new StringBuilder();
		int asciiValue;
		do {
			// Read the each character of the string from the input file
			asciiValue = inputFile.read();
			// Convert character to each HuffmanCode
			result.append(HuffmanCode.get((char) asciiValue));
		} while (asciiValue > 0);
		System.out.println(result);
		return result;
	}

	// Decompress method for client
	public StringBuilder decompress(StringBuilder inputString) {
		StringBuilder result = new StringBuilder();
		while (inputString.length() > 0) {
			result.append(decompress(inputString, overallRoot));
		}
		return result;
	}

	// Decompress input file encoded data to original String(add more parameter than
	// client method)
	private char decompress(StringBuilder inputString, HuffmanNode root) {
		if (root.isLeaf()) {
			return root.character;
		} else {
			char test = inputString.charAt(0);
			inputString.deleteCharAt(0);
			if (test == '0')
				return decompress(inputString, root.left);
			else
				return decompress(inputString, root.right);
		}

	}

	// printSideways method for client
	public String printSideways() {
		return printSideways(overallRoot, 0, strInfor);
	}

	// Make a HuffmanTree to be been actually in side ways (add more parameter than
	// client method)
	private String printSideways(HuffmanNode root, int level, StringBuilder strInfor) {
		if (root != null) {
			printSideways(root.right, level + 1, strInfor);
			for (int i = 0; i < level; i++) {
				strInfor.append("    ");
			}
			if (root.isLeaf())
				strInfor.append(root.frequency + "=char(" + (int) root.character + ")\n\n");
			else
				strInfor.append(root.frequency + "=count\n\n");
			printSideways(root.left, level + 1, strInfor);
		}

		return strInfor.toString();
	}

}
