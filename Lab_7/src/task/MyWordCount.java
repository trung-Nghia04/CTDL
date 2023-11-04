package task;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> re = new ArrayList<>();
		for (String w : words) {
			WordCount wc = new WordCount(w, count(w));
			if (!re.contains(wc)) {
				re.add(wc);
			}
		}
		return re;
	}

	private int count(String w) {
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals(w)) {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> uniqueWords = new HashSet<>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() == 1) {
				uniqueWords.add(wc.getWord());
			}
		}
		return uniqueWords;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> distinctWords = new HashSet<>();
		for (String word : words) {
			distinctWords.add(word);
		}
		return distinctWords;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> wordCounts = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				// TODO Auto-generated method stub
				return o1.getWord().compareTo(o2.getWord());
			}
		});

		wordCounts.addAll(this.getWordCounts());

		return wordCounts;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> wordCounts = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				int re = o1.getCount() - o2.getCount();
				if (re == 0) {
					return o1.getWord().compareTo(o2.getWord());
				}
				return re;
			}
		});
		wordCounts.addAll(this.getWordCounts());
		return wordCounts;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> filteredWords = new HashSet<>();

		for (String word : words) {
			if (!word.startsWith(pattern)) {
				filteredWords.add(word);
			}
		}

		return filteredWords;
	}

	public static void main(String[] args) {
		// Create an instance of MyWordCount to load and process words from a file
		MyWordCount wordCounter = new MyWordCount();

		// Print the words and their counts
		System.out.println("Word Counts:");
		for (WordCount wordCount : wordCounter.getWordCounts()) {
			System.out.println(wordCount.getWord() + " - " + wordCount.getCount());
		}

		// Print unique words
		System.out.println("\nUnique Words:");
		for (String uniqueWord : wordCounter.getUniqueWords()) {
			System.out.println(uniqueWord);
		}

		// Print distinct words
		System.out.println("\nDistinct Words:");
		for (String distinctWord : wordCounter.getDistinctWords()) {
			System.out.println(distinctWord);
		}

		// Print word counts in ascending order of words
		System.out.println("\nWord Counts in Ascending Order of Words:");
		for (WordCount wordCount : wordCounter.printWordCounts()) {
			System.out.println(wordCount.getWord() + " - " + wordCount.getCount());
		}

		// Print word counts in descending order of occurrences
		System.out.println("\nWord Counts in Descending Order of Occurrences:");
		for (WordCount wordCount : wordCounter.exportWordCountsByOccurence()) {
			System.out.println(wordCount.getWord() + " - " + wordCount.getCount());
		}

		// Filter words starting with 'A'
		String filterPattern = "A";
		System.out.println("\nWords after Filtering ('" + filterPattern + "' prefix removed):");
		for (String filteredWord : wordCounter.filterWords(filterPattern)) {
			System.out.println(filteredWord);
		}

	}

}
