/** 
 * @author Joseph Ayo
 * 4/20/2025
 * Project Assignment M6 - CSD 420
 * Program Function: Create a program that runs test cases for the Test Bubble class.
 *  */
// Imports!!!!!
import java.util.Comparator;

public class TestBubbleSort {

    public static void main(String[] args) {

        // Test with Comparable (Integer array)
        Integer[] numbers = {15, 4, 8, 1, 9, 2};
        System.out.println("Original Integer array:");
        BubbleSort.printArray(numbers);

        BubbleSort.bubbleSort(numbers);
        System.out.println("Sorted using Comparable:");
        BubbleSort.printArray(numbers);

        // Test with Comparator (String array, length-based)
        String[] words = {"Daredevil", "Punisher", "Kingpin", "Foggy", "Karen"};
        System.out.println("\nOriginal String array:");
        BubbleSort.printArray(words);

        Comparator<String> byLength = (a, b) -> Integer.compare(a.length(), b.length());
        BubbleSort.bubbleSort(words, byLength);

        System.out.println("Sorted using Comparator:");
        BubbleSort.printArray(words);
    }
}
