package textbookproblem16_2;

/**
 * Computer Science 2 
 * Nolan Stidham 
 * Assignment Number: 16.2 
 * Date Last Edited: 4/3/17 
 * A window for choosing a shape and the fill of the shape
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TextbookProblem16_2 extends Application {
    
    protected BorderPane getPane() {
        Circle circle = new Circle(15, Color.WHITE);
        Rectangle rectangle = new Rectangle(10, 50, Color.WHITE);
        Ellipse ellipse = new Ellipse(25, 10);
        
        circle.setStroke(Color.BLACK);
        rectangle.setStroke(Color.BLACK);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        rectangle.setVisible(false);
        ellipse.setVisible(false);

        //Create a HBox to hold the controls
        HBox paneForButtons = new HBox(20);
        paneForButtons.setPadding(new Insets(5, 5, 5, 5));

        //Create the Radio Buttons and group them
        RadioButton rbCircle = new RadioButton("Circle");
        RadioButton rbRectangle = new RadioButton("Rectangle");
        RadioButton rbEllipse = new RadioButton("Ellipse");

        //Set Default Setting
        rbCircle.setSelected(true);
        
        ToggleGroup groupShapeType = new ToggleGroup();
        rbCircle.setToggleGroup(groupShapeType);
        rbRectangle.setToggleGroup(groupShapeType);
        rbEllipse.setToggleGroup(groupShapeType);

        //Create the Fill Button
        CheckBox cbFill = new CheckBox("Fill");

        //Set Actions
        rbCircle.setOnAction(e -> {
            if (rbCircle.isSelected()) {
                circle.setVisible(true);
                rectangle.setVisible(false);
                ellipse.setVisible(false);
            }
        });
        
        rbRectangle.setOnAction(e -> {
            if (rbRectangle.isSelected()) {
                circle.setVisible(false);
                rectangle.setVisible(true);
                ellipse.setVisible(false);
            }
        });
        
        rbEllipse.setOnAction(e -> {
            if (rbEllipse.isSelected()) {
                circle.setVisible(false);
                rectangle.setVisible(false);
                ellipse.setVisible(true);
            }
        });
        
        cbFill.setOnAction(e -> {
            if (cbFill.isSelected()) {
                circle.setFill(Color.RED);
                rectangle.setFill(Color.GREEN);
                ellipse.setFill(Color.BLUE);
            }
            
            if (!cbFill.isSelected()) {
                circle.setFill(Color.WHITE);
                rectangle.setFill(Color.WHITE);
                ellipse.setFill(Color.WHITE);
            }
            
        });

        //Add and format the controls
        paneForButtons.getChildren().addAll(
                rbCircle, rbRectangle, rbEllipse, cbFill);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: black");

        //Create main pane
        BorderPane mainPane = new BorderPane();

        //Add control pane to the bottom of window
        mainPane.setBottom(paneForButtons);

        //Create the viewing pane
        StackPane paneForShape = new StackPane();
        paneForShape.setPadding(new Insets(20, 20, 20, 20));
        paneForShape.getChildren().addAll(circle, rectangle, ellipse);
        paneForShape.setAlignment(Pos.CENTER);
        paneForShape.setStyle("-fx-background-color: white");

        //Add viewing pane to center of window
        mainPane.setCenter(paneForShape);
        
        return mainPane;
    }
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane());
        primaryStage.setTitle("Textbook Problem 16.2"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}