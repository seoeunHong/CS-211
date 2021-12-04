
/* Author: Seoeun Hong; Date: 10/11/2019;
 * Class: CS211; Project Name: StableMarriage;
 * Description: This class reads data file and store each names and preferences on the each ArrayList;
 * According to preferences for both, it matches proper partner for both of them;
 */
// This program reads an input file of preferences and find a stable marriage
// scenario.  The algorithm gives preference to either men or women depending
// upon whether this call is made from main:
//      makeMatches(men, women);
// or whether this call is made:
//      makeMatches(women, men);

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StableMarriage {
	public static final String LIST_END = "END";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		System.out.print("What is the input file? ");
		String fileName = console.nextLine();
		Scanner input = new Scanner(new File(fileName));
		System.out.println();

		List<Person> men = readHalf(input);
		List<Person> women = readHalf(input);
		makeMatches(men, women);
		writeList(men, women, "Matches for men");
		writeList(women, men, "Matches for women");
	}

	public static Person readPerson(String line) {
		int index = line.indexOf(":");
		Person result = new Person(line.substring(0, index));
		Scanner data = new Scanner(line.substring(index + 1));
		while (data.hasNextInt()) {
			result.addChoice(data.nextInt());
		}
		return result;
	}

	public static List<Person> readHalf(Scanner input) {
		List<Person> result = new ArrayList<Person>();
		String line = input.nextLine();
		while (!line.equals(LIST_END)) {
			result.add(readPerson(line));
			line = input.nextLine();
		}
		return result;
	}

	// This method sets proper partner for man and continues matching until man is
	// possible to be matched;
	// Take two list<Person> type variable as parameter to take men and women's list
	public static void makeMatches(List<Person> list1, List<Person> list2) {
		// Remove partners of all men
		for (Person m : list1) {
			m.erasePartner();
		}
		// Remove partners of all women
		for (Person w : list2) {
			w.erasePartner();
		}
		// Set initial index as 0 to start matching from first man;
		int mIndex = 0;
		// Let the process go through from first to the end to find qualified men to be
		// matched;
		for (; mIndex < list1.size(); mIndex++) {
			// Return true when man satisfies matching conditions;
			// man should not have partner, but has an ability for choosing woman;
			if (!list1.get(mIndex).hasPartner() && list1.get(mIndex).hasChoices()) {
				int firChoiceW = list1.get(mIndex).getFirstChoice();
				Person chosenW = list2.get(firChoiceW);
				Person choiceMan = list1.get(mIndex);
				// Erase woman from another partner when woman is engaged with him;
				if (chosenW.hasPartner()) {
					int prePartner = chosenW.getPartner();
					list1.get(prePartner).erasePartner();
				}
				// Engage man and woman
				choiceMan.setPartner(firChoiceW);
				chosenW.setPartner(mIndex);
				// Erase woman's lesser preference man
				for (int index = chosenW.getChoices().size() - 1; index > chosenW.getChoices()
						.indexOf(mIndex); index--) {
					chosenW.getChoices().remove(index);

				}
				// Erase woman from other men's choice list if man isn't on woman's choice list;
				for (int index = 0; index < list1.size(); index++) {
					if (!chosenW.getChoices().contains(index) && list1.get(index).getChoices().contains(firChoiceW)) {
						int indexW = list1.get(index).getChoices().indexOf(firChoiceW);
						list1.get(index).getChoices().remove(indexW);
					}
				}
				// Do matching process again from the first until no men left who satisfies
				// matching condition;
				mIndex = 0;
			}

		}
	}

	public static void writeList(List<Person> list1, List<Person> list2, String title) {
		System.out.println(title);
		System.out.println("Name           Choice  Partner");
		System.out.println("--------------------------------------");
		int sum = 0;
		int count = 0;
		for (Person p : list1) {
			System.out.printf("%-15s", p.getName());
			if (!p.hasPartner()) {
				System.out.println("  --    nobody");
			} else {
				int rank = p.getPartnerRank();
				sum += rank;
				count++;
				System.out.printf("%4d    %s\n", rank, list2.get(p.getPartner()).getName());
			}
		}
		System.out.println("Mean choice = " + (double) sum / count);
		System.out.println();
	}

}
