/** 
 * @author Joseph Ayo
 * 4/27/2025
 * Project Assignment M8 - CSD 420
 * Program Function: Create a program that creates 10000 randomly generated characters and displays them without crashing.
 *  */
// Imports!!!!!
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ThreeThreads extends JFrame {
    private static final int CHAR_COUNT = 10000; // Number of characters each thread will generate
    private JTextArea textArea;
    private Random random = new Random(); // Random number generator

    public ThreeThreads() {
        // Set up the text window
        setTitle("Three Threads Output");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the text area inside a scroll pane
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane); // Add scroll pane to the window

        setVisible(true); // Make the window visible

        // Start the threads
        startThreads();
    }

    private void startThreads() {
        // Create three threads, each running a different task
        Thread lettersThread = new Thread(() -> generateRandomLetters());
        Thread numbersThread = new Thread(() -> generateRandomNumbers());
        Thread symbolsThread = new Thread(() -> generateRandomSymbols());

        // Start each thread
        lettersThread.start();
        numbersThread.start();
        symbolsThread.start();
    }

    // Generate random lowercase letters and add them to the text 
    private void generateRandomLetters() {
        for (int i = 0; i < CHAR_COUNT; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            appendText(letter);
            sleepSlightly(); 
        }
    }

    // Generate random numbers and add them to the text 
    private void generateRandomNumbers() {
        for (int i = 0; i < CHAR_COUNT; i++) {
            char number = (char) ('0' + random.nextInt(10));
            appendText(number);
            sleepSlightly(); 
        }
    }

    // Generate random special characters and add them to the text
    private void generateRandomSymbols() {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        for (int i = 0; i < CHAR_COUNT; i++) {
            char symbol = symbols[random.nextInt(symbols.length)];
            appendText(symbol);
            sleepSlightly();
        }
    }

    // Append a character to the text area (safely from any thread)
    private void appendText(char c) {
        SwingUtilities.invokeLater(() -> textArea.append(Character.toString(c)));
    }

    // Temporary sleep to slow down output
    private void sleepSlightly() {
        try {
            Thread.sleep(1); // 1ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ThreeThreads());
    }
}
