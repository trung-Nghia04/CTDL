package task_1;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		TextAnalyzer text = new TextAnalyzer();
		text.load("data/short.txt");
		System.out.println("displayWords:");
		text.displayWords();
		System.out.println("displayText:");
		text.displayText();
		System.out.println("mostFrequentWord: ");
		System.out.println(text.mostFrequentWord());
	}
}
