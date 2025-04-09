/** 
 * @author Joseph Ayo
 * 4/5/2025
 * Project Assignment M3 - CSD 420
 * Program Function: Create a program that writes two array lists. The first has 50 random valuesbetween 1 and 20.
 *  The second array list contains only originalk, non-duplicate values from the original array list.  */
// Imports!!! 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
// Main class
public class ModuleThree {
    
    public static void main(String[] args) {
        // Creating ArrayList with 50 random values between 1 and 20
        ArrayList<Integer> theList = new ArrayList<>();
        Random rand = new Random();
        
        for (int i = 0; i < 50; i++) {
            theList.add(rand.nextInt(20) + 1);  // Generate random numbers between 1 and 20
        }

        // Print the original list
        System.out.println("Original List: " + theList);

        // Call removeDuplicates
        ArrayList<Integer> noDuplicatesList = removeDuplicates(theList);

        // Print the new list
        System.out.println("List without duplicates: " + noDuplicatesList);
    }
    
    // Method that removes duplicates from an ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Useing HashSet to automatically remove duplicates
        return new ArrayList<>(new HashSet<>(list));
    }
}
