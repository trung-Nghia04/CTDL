package set_student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
//		 Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File("data/fit.txt"));
		System.out.println("cac tu trong file: ");
		while (input.hasNext()) {
			String word = input.next();
			System.out.print(word + " ");
		}
		System.out.println();

		MyWordCount count = new MyWordCount();
		System.out.println("getWordCounts: \n" + count.getWordCounts());
		System.out.println("getUniqueWords: \n" + count.getUniqueWords());
		System.out.println("getDistinctWords: \n" + count.getDistinctWords());
		System.out.println("printWordCounts: \n" + count.printWordCounts());
		System.out.println("exportWordCountsByOccurence: \n" + count.exportWordCountsByOccurence());
		System.out.println("filterWords: \n" + count.filterWords("D"));
	}
}