package Pack;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoffeeShoppeGUI extends Application {

	String result;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Jim Coffee Shoppe");
		
		// Initializing values for the buttons
		final double small = 1.25;
		int totSmall = 0;
		final double med = 0;
		int totMed = 0;
		final double large = 0;
		int totLarge = 0;
		
		Label label1 = new Label("Name:");
		TextField textField = new TextField();
		textField.setText("Name here and click the Enter key when done");
		textField.setText("Name here");
		textField.getText();

		// Creating a Text object
		Text text = new Text();

		// Setting font to the text
		text.setFont(new Font(45));

		// setting the position of the text
		text.setX(100);
		text.setY(50);
		text.setWrappingWidth(0);

		System.out.println(textField.getText());
		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					text.setText("Welcome " + textField.getText());
				}
			}
		});
		text.setX(50);
		text.setY(150);

		// Setting the text to be added.
		text.setText("Welcome ");

		// Creating a Group object
		Group root = new Group();
		
		// Creating button options
		Button btn = new Button();
		btn.setText("testing");
		btn.setLayoutX(50);
		btn.setLayoutY(200);
		btn.setOnKeyPressed(new EventHandler<KeyEvent> () {
			
			@Override
			public void handle(KeyEvent event) {
				System.out.println("Button");
			}
			
		});
		
		
		// Retrieving the observable list object
		ObservableList list = root.getChildren();

		// Setting the text object as a node to the group object
		list.add(text);
		list.add(textField);
		list.add(btn);

		// Creating a scene object
		Scene scene = new Scene(root, 600, 600);

		// Setting title to the Stage
		primaryStage.setTitle("Sample Application");

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();
	}
}
