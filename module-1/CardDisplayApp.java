/** 
 * @author Joseph Ayo
 * 3/23/2025
 * Project Assignment M1 - CSD 420
 * Program Function: Create an application that randomly chooses and displays four cards from a traditional deck. Include a refresh button
 * that will reroll the cards displayed.  */
//First up, imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Our primary class
public class CardDisplayApp extends Application {
//Important static variables
    private static final int CARD_COUNT = 52;
    private static final String CARD_PATH = "cards/";
    private static final int CARD_WIDTH = 100;

    private HBox cardBox = new HBox(10);

    @Override
    //Creating the elements of the window
    public void start(Stage primaryStage) {
        cardBox.setPadding(new Insets(15));
//Refresh button
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> showRandomCards());

        VBox root = new VBox(10, cardBox, refreshButton);
        root.setPadding(new Insets(15));

        showRandomCards();
//Displaying card .png files
        Scene scene = new Scene(root);
        primaryStage.setTitle("Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//Choosing cards to display
    private void showRandomCards() {
        cardBox.getChildren().clear();

        List<Integer> cardIndices = new ArrayList<>();
        for (int i = 1; i <= CARD_COUNT; i++) {
            cardIndices.add(i);
        }

        Collections.shuffle(cardIndices);

        // Using lambda
        cardIndices.stream()
                   .limit(4)
                   .forEach(i -> {
                    Image image = new Image(new File("cards/" + i + ".png").toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(CARD_WIDTH);
                     imageView.setPreserveRatio(true);
                    cardBox.getChildren().add(imageView);
                   });
    }
//Running the program
    public static void main(String[] args) {
        launch(args);
    }
}
