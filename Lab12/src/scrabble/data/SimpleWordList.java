package scrabble.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import scrabble.util.Permutation;

public class SimpleWordList implements WordList {

	private Set<String> wordSet;

	@Override
	public Set<String> validWordsUsingAllTiles(String tileRack) {
		Set<String> validWords = new HashSet<>();
		Permutation tileRackPermutation = new Permutation(tileRack);
		for (String word : wordSet) {
			if (word.length() == tileRack.length() && tileRackPermutation.equals(new Permutation(word))) {
				validWords.add(word);
			}
		}
		return validWords;
	}

	@Override
	public Set<String> allValidWords(String tileRack) {
		Set<String> validWords = new HashSet<>();
		for (String word : wordSet) {
			if (word.length() <= tileRack.length() && new Permutation(word).equals(new Permutation(tileRack))) {
				validWords.add(word);
			}
		}
		return validWords;
	}

	@Override
	public boolean add(String word) {
		return wordSet.add(word);
	}

	@Override
	public boolean addAll(Collection<String> words) {
		return wordSet.addAll(words);
	}

	@Override
	public int size() {
		return wordSet.size();
	}

	@Override
	public WordList initFromFile(String fileName) {
		wordSet = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				wordSet.add(line.toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
}
