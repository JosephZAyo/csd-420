/** 
 * @author Joseph Ayo
 * 4/13/2025
 * Project Assignment M5 - CSD 420
 * Program Function: Create a program that reads words from a text file and displays all non-duplicate words in ascending order and then in descending order.
 *  The word file is titled collection_of_words.txt. */
// Imports!!!!
import java.io.*;
import java.util.*;

public class WordSorter {

    public static void main(String[] args) {
        String filename = "collection_of_words.txt";
        
        // Create collection_of_words file
        createTestFile(filename);

        // Read and sort words within the file
        Set<String> uniqueWords = readWordsFromFile(filename);

        // Convert to list for easier sorting
        List<String> wordList = new ArrayList<>(uniqueWords);

        // print in ascending order
        Collections.sort(wordList);
        System.out.println("Words in Ascending Order:");
        for (String word : wordList) {
            System.out.println(word);
        }

        // print in descending order
        Collections.sort(wordList, Collections.reverseOrder());
        System.out.println("\nWords in Descending Order:");
        for (String word : wordList) {
            System.out.println(word);
        }
    }

    // Reads words from the file and stores non-duplicates in a Set
    public static Set<String> readWordsFromFile(String filename) {
        Set<String> wordSet = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    wordSet.add(word);
                }
            }
        //Catch errors
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return wordSet;
    }

    // Sample file for testing
    public static void createTestFile(String filename) {
        String[] sampleWords = {
            "apple", "Banana", "apple,", "orange", "banana", "Kiwi", "grape", "Orange", "lemon"
        };

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (String word : sampleWords) {
                writer.print(word + " ");
            }
        } catch (IOException e) {
            System.err.println("Error writing test file: " + e.getMessage());
        }
    }
}
