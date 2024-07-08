// HashMapWordList.java
package scrabble.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import scrabble.util.Permutation;

public class HashMapWordList implements WordList {

    private Map<Permutation, Set<String>> wordMap;

    @Override
    public Set<String> validWordsUsingAllTiles(String tileRackPart) {
        Permutation rackPerm = new Permutation(tileRackPart);
        return wordMap.getOrDefault(rackPerm, new HashSet<>());
    }

    @Override
    public Set<String> allValidWords(String tileRack) {
        Set<String> validWords = new HashSet<>();
        Permutation rackPerm = new Permutation(tileRack);
        for (Map.Entry<Permutation, Set<String>> entry : wordMap.entrySet()) {
            if (entry.getKey().length() <= rackPerm.length() && entry.getKey().equals(rackPerm)) {
                validWords.addAll(entry.getValue());
            }
        }
        return validWords;
    }

    @Override
    public boolean add(String word) {
        Permutation perm = new Permutation(word);
        return wordMap.computeIfAbsent(perm, k -> new HashSet<>()).add(word);
    }

    @Override
    public boolean addAll(Collection<String> words) {
        boolean added = false;
        for (String word : words) {
            added |= add(word);
        }
        return added;
    }

    @Override
    public int size() {
        return wordMap.values().stream().mapToInt(Set::size).sum();
    }

    @Override
    public WordList initFromFile(String fileName) {
        wordMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                add(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}