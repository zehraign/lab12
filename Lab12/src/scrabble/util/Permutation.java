package scrabble.util;

import java.util.Arrays;

public class Permutation {

	private String word;

	public Permutation(String word) {
		this.word = word;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(word.toCharArray());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Permutation other = (Permutation) obj;
		// Use getNormalized to compare normalized versions of words
		return getNormalized().equals(other.getNormalized());
	}

	@Override
	public String toString() {
		return getWord() + " / " + getNormalized();
	}

	public String getNormalized() {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public String getWord() {
		return word;
	}

	public int length() {
		return word.length();
	}
}
