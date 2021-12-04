import java.util.Arrays;
import java.util.Random;

/* Author: Seoeun Hong; Date: 10/25/2019;
 * Class: CS211; Project Name: BogoSort;
 * Description: Set random int value array whose int range is from 1 to 200 and 
 * 				shuffle it randomly until it is sorted;
 * 				Calculate and show the time it takes to shuffle on the console;
 * */

public class BogoSort {
	public static final int Array_Size = 12;

	public static void main(String[] args) {
		int[] myArray = new int[Array_Size];
		assignValue(myArray);
		// Record the time before starting shuffle;
		long startTime = System.currentTimeMillis();
		long shuffleCount = bogoSort(myArray);
		// Record the time after finishing shuffle sorting ;
		long endTime = System.currentTimeMillis();
		// Show the length of time it took by subtracting endTime from startTIme;
		System.out.println("Suffle Time (ms): " + (endTime - startTime));
		// Show the number of shuffle for predicting Big-O of this class
		System.out.println("Shuffle Count: " + shuffleCount);
		printArray(myArray);
	}

	// Assign random int value number whose range is from 1 to 200 on myArray
	// elements;
	public static void assignValue(int[] array) {
		Random random = new Random();
		for (int index = 0; index < array.length; index++) {
			array[index] = random.nextInt(200) + 1;
		}
	}

	// Places the elements of a into sorted order.
	// Return long value which indicate shuffle Count for predicting Big-O;
	public static long bogoSort(int[] a) {
		long shuffleCount = 0;
		while (!isSorted(a)) {
			shuffle(a);
			shuffleCount++;
		}
		return shuffleCount;
	}

	// Returns true if a's elements are in sorted order.
	public static boolean isSorted(int[] a) {
		for (int index = 0; index < a.length - 1; index++)
			if (a[index + 1] < a[index])
				return false;
		return true;
	}

	// Shuffles an array of ints by randomly swapping each
	// element with an element in the array.
	public static void shuffle(int[] a) {
		Random random = new Random();
		for (int index = 1; index < a.length; index++) {
			swap(a, index, random.nextInt(a.length));
		}
	}

	// Swaps a[i] with a[j].
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void printArray(int[] a) {
		System.out.println(Arrays.toString(a));

	}

}
