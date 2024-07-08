package scrabble.util;

import java.util.HashSet;
import java.util.Set;

public class SubSets {

	public static Set<String> getSubSets(String str) {
		Set<String> subsets = new HashSet<>();
		if (str.length() == 0) {
			subsets.add("");
			return subsets;
		}
		char firstChar = str.charAt(0);
		String remainingChars = str.substring(1);
		Set<String> subsetsWithoutFirstChar = getSubSets(remainingChars);
		subsets.addAll(subsetsWithoutFirstChar);
		for (String subset : subsetsWithoutFirstChar) {
			subsets.add(firstChar + subset);
		}
		return subsets;
	}
}