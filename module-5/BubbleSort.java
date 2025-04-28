/** 
 * @author Joseph Ayo
 * 4/20/2025
 * Project Assignment M6 - CSD 420
 * Program Function: Create a program that can sort arrays using Comparable and Comparator interfaces.
 *  The Test cases are handled by TestBubbleSort.java. */
// Imports!!!!
import java.util.Comparator;

public class BubbleSort {

    /**
     *  using Comparable interface (Sorts the array in ascending order)
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    /**
     * using Comparator interface
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Print the array
    public static <E> void printArray(E[] array) {
        System.out.print("{ ");
        for (E e : array) {
            System.out.print(e + " ");
        }
        System.out.println("}");
    }
}
