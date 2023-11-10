package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		int index = 1;
		String line;

		while ((line = reader.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String w = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
					add(w, index);
				} else {
					add(w, -index);
				}
				index++;
			}
		}

		reader.close();
	}

	@Override
	public String toString() {
		return "TextAnalyzer [map=" + map + "]";
	}

	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file
	public void add(String word, int position) {
		if (map.containsKey(word)) {
			if (position < 0) {
				position = -position;
			}
			map.get(word).add(position);
		} else {
			ArrayList<Integer> positions = new ArrayList<>();
			if (position < 0) {
				position = -position;
			}
			positions.add(position);
			map.put(word, positions);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> entry = new TreeMap<>();
		entry.putAll(this.map);
		System.out.println(entry + "");

	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		List<Integer> allPositions = new ArrayList<>();

		for (ArrayList<Integer> positions : map.values()) {
			allPositions.addAll(positions);
		}

		Collections.sort(allPositions);

		for (int position : allPositions) {
			for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
				String word = entry.getKey();
				ArrayList<Integer> positions = entry.getValue();

				if (positions.contains(position)) {
					System.out.print(word + " " );
					break;
				}
			}
		}

		System.out.println();
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String mostFrequent = null;
		int maxFrequency = 0;

		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> positions = entry.getValue();
			int frequency = positions.size();

			if (frequency > maxFrequency) {
				maxFrequency = frequency;
				mostFrequent = entry.getKey();
			}
		}

		return mostFrequent;
	}

}
