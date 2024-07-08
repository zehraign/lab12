package scrabble;

import scrabble.data.HashMapWordList;
import scrabble.data.SimpleWordList;
import scrabble.data.WordList;

import java.util.Set;

public class Main {

    private WordList wordList;

    public Main(WordList wordList) {
        this.wordList = wordList;
    }

    public void run() {
        // Example usage
        wordList.initFromFile("/Users/atoosa/LabWork/InfoWork/Lab12/wordlists/sowpods.txt");

        // Example tile rack
        String tileRack = "tjs"; // Replace with actual tile rack input
        Set<String> validWords = wordList.validWordsUsingAllTiles(tileRack);
        System.out.println("Valid words using all tiles: " + validWords);

        // Additional functionality as needed
    }

    public static void main(String[] args) {
        // Example usage
        WordList simpleWordList = new SimpleWordList();
        WordList hashMapWordList = new HashMapWordList();

        Main cheater = new Main(simpleWordList);
        cheater.run();
    }
}
