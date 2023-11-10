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
		  WordCount wc = new WordCount(w,count(w));
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

	// Returns the words that their appearance are 1, do not consider duplidated words
	public Set<String> getUniqueWords() {
		 Set<String> uniqueWords = new HashSet<>();
		 for (WordCount wc : getWordCounts()) {
			if (wc.getCount() == 1) {
				uniqueWords.add(wc.getWord());
			}
		}
		return uniqueWords;
	}

	// Returns the words in the text file, duplicated words appear once in the result
	public Set<String> getDistinctWords() {
		  Set<String> distinctWords = new HashSet<>();
		  for (String word : words) {
		    distinctWords.add(word);
		  }
		  return distinctWords;
		}


	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of occurrences
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
	    Set<WordCount> wordCounts = new TreeSet<>(new Comparator<WordCount>() {

	        @Override
	        public int compare(WordCount o1, WordCount o2) {
	            // Compare based on counts in ascending order
	            int countComparison = o1.getCount() - o2.getCount();
	            if (countComparison == 0) {
	                // If counts are equal, compare based on words in lexicographical order
	                return o1.getWord().compareTo(o2.getWord());
	            }
	            return countComparison;
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
		            // Compare based on counts in ascending order
		            int countComparison = o2.getCount() - o1.getCount();
		            if (countComparison == 0) {
		                return o2.getWord().compareTo(o1.getWord());
		            }
		            return countComparison;
		        }
		    });

		    wordCounts.addAll(this.getWordCounts());

		    return wordCounts;
	}

	// delete words begining with the given pattern (i.e., delete words begin with 'A' letter
	public Set<String> filterWords(String pattern) {
	    Set<String> filteredWords = new HashSet<>();

	    for (String word : words) {
	        if (!word.startsWith(pattern)) {
	            filteredWords.add(word);
	        }
	    }

	    return filteredWords;
	}
	

}
