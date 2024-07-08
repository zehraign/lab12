// WordList.java
package scrabble.data;

import java.util.Collection;
import java.util.Set;

public interface WordList {
	public static final int MIN_WORD_LENGTH = 2;
	public static final int ALPHABET_SIZE = 26;
	public static final char FIRST_CHARACTER = 'a';
	public static final char LAST_CHARACTER = 'z';

	Set<String> validWordsUsingAllTiles(String tileRackPart);

	Set<String> allValidWords(String tileRack);

	boolean add(String word);

	boolean addAll(Collection<String> words);

	int size();

	WordList initFromFile(String fileName);
}
