/** 
 * @author Joseph Ayo
 * 3/27/2025
 * Project Assignment M2 - CSD 420
 * Program Function: Create a program that writes two arrays with 5 values contained within. Write it to 'JAyodatafile.dat',
 * and append successive writes into this file.  */
//Imports!!! 
import java.io.*;
import java.util.Random;
//Main class
public class WriteData {
    public static void main(String[] args) {
        String filename = "JAyodatafile.dat";
        Random rand = new Random();

        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        // Generate random integers and doubles
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100); // Random integers between 0-99
            doubleArray[i] = rand.nextDouble() * 100; // Random doubles between 0-100
        }
            //Create new file if necessary, or append successive writes
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Integers: ");
            for (int num : intArray) {
                writer.write(num + " ");
            }
            writer.newLine();

            writer.write("Doubles: ");
            for (double num : doubleArray) {
                writer.write(String.format("%.2f ", num));
            }
            writer.newLine();
            writer.write("----------------------");
            writer.newLine();

            System.out.println("Data written successfully to " + filename);
        } catch (IOException e) { //Catch exceptions
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
}
