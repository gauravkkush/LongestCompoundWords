import java.io.*;
import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public String[] longestCompoundWord(String[] words) {
        String[] result = { "", "" };

        for (String word : words) {
            // insert(word);
            if (isCompoundWord(word, 0, root, 0, false)) {
                if (word.length() > result[0].length()) {
                    result[1] = result[0];
                    result[0] = word;
                } else if (word.length() > result[1].length() || result[1] == null) {
                    result[1] = word;
                }
            }
        }
        return result;
    }

    private boolean isCompoundWord(String word, int start, TrieNode node, int count, boolean prefixMatch) {
        // if the word is made from 2 or more words from the input array
        if (!prefixMatch) {
            // Check for prefix match before entering recursion to reduce redundent
            // recursive calls
            for (int i = start; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
                if (node.isEndOfWord && isCompoundWord(word, i + 1, root, count + 1, true)) {
                    return true;
                }
            }
            return false;
        }

        for (int i = start; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
            if (node.isEndOfWord) {
                if (i == word.length() - 1) {
                    return count >= 1;
                }
                if (isCompoundWord(word, i + 1, node, count + 1, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {

        // change file name here to : "Input_01.txt", "Input_02.txt"
        File inputFile = new File("Input_01.txt");

        Scanner scanner = new Scanner(inputFile);

        Trie trie = new Trie();

        List<String> wordList = new ArrayList<>();

        // Read words from the file
        while (scanner.hasNext()) {
            String word = scanner.next();
            // System.out.println(word); // debugging to check if file is read
            trie.insert(word);
            wordList.add(word);
        }

        scanner.close();

        String words[] = wordList.toArray(new String[0]);

        long start = System.currentTimeMillis(); // startTime

        String[] result = trie.longestCompoundWord(words);

        long end = System.currentTimeMillis(); // endTime

        System.out.println("Longest Compound Word: " + result[0]);
        System.out.println("Second Longest Compound Word: " + result[1]);
        System.out.println("Total Runtime: " + (end - start) + "ms");
    }
}
