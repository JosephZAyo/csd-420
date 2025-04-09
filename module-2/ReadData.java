/** 
 * @author Joseph Ayo
 * 3/27/2025
 * Project Assignment M2 - CSD 420
 * Program Function: Create a program that is capable of reading 'JAyodatafile.dat' and outputting the contents.
 * Includes all appended arrays.  */
//Import timeee
import java.io.*;
//Main class
public class ReadData {
    public static void main(String[] args) {
        String filename = "JAyodatafile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            System.out.println("Reading from " + filename + ":\n"); //Print loading message
            while ((line = reader.readLine()) != null) {
                System.out.println(line); //Print contents of .dat file
            }

        } catch (FileNotFoundException e) { //Catch common exceptions
            System.out.println("The file " + filename + " does not exist.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
