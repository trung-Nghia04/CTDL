package set_student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

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
			if (!updateWC(re, w)) {
				re.add(new WordCount(w, 1));
			}
		}
		return re;

	}

	private boolean updateWC(List<WordCount> list, String w) {
		for (WordCount wc : list) {
			if (wc.getWord().equals(w)) {
				wc.setCount(wc.getCount() + 1);
				return true;
			}
		}
		return false;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> re = new HashSet<>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() == 1)
				re.add(wc.getWord());
		}
		return re;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> re = new HashSet<>();
		for (String w : words) {
			re.add(w);
		}
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		TreeSet<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		re.addAll(getWordCounts());
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		TreeSet<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				int byCount = o2.getCount() - o1.getCount();
				if (byCount == 0) {
					return o1.getWord().compareTo(o2.getWord());
				} else {
					return byCount;
				}
			}
		});
		re.addAll(getWordCounts());
		return re;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> re = new HashSet<>();
		for (String w : words) {
			if (!w.startsWith(pattern)) {
				re.add(w);
			}
		}
		return re;
	}
}
