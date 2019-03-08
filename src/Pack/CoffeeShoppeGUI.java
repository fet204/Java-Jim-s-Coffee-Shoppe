package Pack;

import java.util.Optional;

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
	Text text;
	TextField tf;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Jim Coffee Shoppe");

		// Button for name change
		Button b = new Button("Want to change your name?");
		b.setTranslateX(175);
		b.setTranslateY(75);
		b.setVisible(false);

		Label label1 = new Label("Name:");

		// Make a text field object
		tf = new TextField("Enter name here");

		// Creating a Text object
		text = new Text();

		// Setting font to the text
		text.setFont(new Font(45));

		System.out.println(tf.getText());
		tf.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					b.setVisible(true);
					tf.setVisible(false);
					changeText(tf.getText(), text);
				}
			}
		});

		b.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                showInputDialog(text);
            }
        });

		text.setX(175);
		text.setY(50);

		// Creating a Group object
		Group root = new Group();

		// Retrieving the observable list object
		ObservableList list = root.getChildren();

		// Setting the text object as a node to the group object
		list.add(text);
		list.add(tf);
		list.add(b);

		// Creating a scene object
		Scene scene = new Scene(root, 600, 600);

		// Setting title to the Stage
		primaryStage.setTitle("Sample Application");

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();
	}
	
	private static void showInputDialog(Text t) {
		TextInputDialog d = new TextInputDialog("Change");
		 
        d.setTitle("Change name");
        d.setHeaderText("Enter your name:");
        d.setContentText("Name:");
 
        Optional<String> result = d.showAndWait();
        String trueResult = result.get();
        result.ifPresent(name -> {
            changeText(trueResult, t);
        });
    }
	
	private static void changeText(String result, Text t) {
		t.setText("Welcome " + result);
	}
}
