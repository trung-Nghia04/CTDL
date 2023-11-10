package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyWordCountApp {
	//public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		while(input.hasNext()) {
			String word = input.next();
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
	}

	// Returns the number of distinct tokens in the file data/hamlet.txt or fit.txt
	public int countDistinct() throws FileNotFoundException {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
	    Map<String, Integer> wordCountMap = new TreeMap<>(new Comparator<String>() {
	        @Override
	        public int compare(String word1, String word2) {
	            int count1 = map.get(word1);
	            int count2 = map.get(word2);

	            if (count1 < count2) {
	                return -1;
	            } else if (count1 > count2) {
	                return 1;
	            } else {
	                return word1.compareTo(word2);
	            }
	        }
	    });

	    wordCountMap.putAll(map);
	    for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
	        System.out.println(entry.getKey() + " - " + entry.getValue());
	    }
	}

}

