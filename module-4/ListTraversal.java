/** 
 * @author Joseph Ayo
 * 4/6/2025
 * Project Assignment M4 - CSD 420
 * Program Function: Create a program that compares the traversal time of an Iterator versus get(index)
 * Output: The traversal time of each method, allowing for a simple comparison.  */
// Imports!!! 
import java.util.LinkedList;
import java.util.Iterator;

public class ListTraversal {
    // Main 
    public static void main(String[] args) {
        System.out.println("Testing with 50,000 elements:");
        testTraversal(50000);

        System.out.println("\nTesting with 500,000 elements:");
        testTraversal(500000);
    }

    public static void testTraversal(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Populate the list
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Traverse the list using iterator, output results in ms
        long startIterator = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endIterator = System.nanoTime();
        long durationIterator = endIterator - startIterator;
        System.out.println("Iterator traversal time: " + durationIterator / 1_000_000.0 + " ms");

        // Traverse the list using get(index), output results in ms
        long startGet = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i); // This is O(n) per access in LinkedList!
        }
        long endGet = System.nanoTime();
        long durationGet = endGet - startGet;
        System.out.println("get(index) traversal time: " + durationGet / 1_000_000.0 + " ms");

        // Verify success
        if (list.get(0) != 0 || list.get(size - 1) != size - 1) {
            System.out.println("Test failed: Data mismatch.");
        } else {
            System.out.println("Test passed: Data verified.");
        }
    }
}

/*
 * Further Comments:
 *
 * The `Iterator` traversal is significantly faster than the `get(index)` traversal for the LinkedList. It isn't even close.
 * This seems to happen because Iterator moves sequentially through the list, whereas get(index) travels from the front of the list to the given index, every iteration.
 * Doing this drastically increases the amount of times that the index needs to be referenced, increasing the necessary computations needed to come to the same result as the iterator.
 * - `get(index)` performs a traversal from the head of the list to the given index each time, making it O(n^2) for n accesses.
 *
 * My conclusion is that you should avoid using get(index) for traversing LinkedList, especially when iterating through large lists with thousands of entries. Use Iterators instead.
 */