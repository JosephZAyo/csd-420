import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FourCircles extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Define circle radius
        double circleRadius = 50; // 50 radius = 100 diameter

        // Rectangle that matches the circle's diameter
        Rectangle borderRect = new Rectangle(50, 25, circleRadius * 2, 350);
        borderRect.getStyleClass().add("border");

        // Create first circle
        Circle circle1 = new Circle(
                borderRect.getX() + circleRadius,  // center X = rect X + radius
                200,  
                circleRadius
        );
        circle1.toBack();

        //Circle spacing
        double spacing = (circleRadius * 2) + 10;

        // Create the next three circles
        Circle circle2 = new Circle(circle1.getCenterX() + spacing,200, circleRadius);
        Circle circle3 = new Circle(circle2.getCenterX() + spacing,200, circleRadius);
        Circle circle4 = new Circle(circle3.getCenterX() + spacing,200, circleRadius);

        // Obtain styles from .css
        circle1.getStyleClass().add("plainCircle");
        circle2.getStyleClass().add("plainCircle");
        circle3.setId("redcircle");
        circle4.setId("greencircle");

        // Add everything to the window
        pane.getChildren().addAll(borderRect, circle1, circle2, circle3, circle4);

        // Create the scene, link the stylesheet to the program
        Scene scene = new Scene(pane, 500, 400);
        scene.getStylesheets().add(getClass().getResource("Stylesheet.css").toExternalForm());

        primaryStage.setTitle("Exercise31_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
