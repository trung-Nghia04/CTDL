package task_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 1.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int i = 1;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				add(word, tokens.hasMoreTokens() ? i : -i);
				i++;
			}
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		ArrayList<Integer> value = map.getOrDefault(word, new ArrayList<Integer>());
		value.add(position);
		map.put(word, value);
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		System.out.println("Word	Word Position(s)");
		System.out.println("========================");
		for (String key : map.keySet()) {
			System.out.println(key + "	" + map.get(key));
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		TreeMap<Integer, String> re = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o1) - Math.abs(o2);
			}
		});

		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			String w = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			for (Integer k : val) {
				re.put(k, w);
			}
		}
		for (Integer key : re.keySet()) {
			System.out.println(key + "	" + re.get(key));
		}

	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String re = null;
		int max = 0;
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() > max) {
				max = entry.getValue().size();
				re = entry.getKey();
			}
		}
		return re;
	}
}