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
<<<<<<< HEAD
	Text text;
	TextField tf;
=======
	
	// Initializing values for the buttons
	double small = 1.25;
	int totSmall = 0;
	double med = 1.75;
	int totMed = 0;
	double large = 2.30;
	int totLarge = 0;
	
	// initializing the values for the extras button
	int creamC = 0;
	int rawSugarC = 0;
	int espressoShotC = 0;
	double espressoPrice = 0.75;
	
>>>>>>> fbe5ec39a3b772349c73cd9b82c315540759849b
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Jim Coffee Shoppe");
<<<<<<< HEAD

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
=======
			
		Label label1 = new Label("Name:");
		TextField textField = new TextField();
		textField.setText("Name here and click the Enter key when done");
		textField.setText("Name here");
		textField.getText();

		// Creating a Text object
		Text text = new Text();
>>>>>>> fbe5ec39a3b772349c73cd9b82c315540759849b

		// Setting font to the text
		text.setFont(new Font(45));

<<<<<<< HEAD
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

=======
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
		
		// Creating small coffee button options
		Button btn = new Button();
		btn.setText("Press for 1 Small Coffee");
		btn.setLayoutX(50);
		btn.setLayoutY(200);
		btn.setOnAction(new EventHandler<ActionEvent> () {
			
			@Override
			public void handle(ActionEvent event) {
				totSmall++;
				System.out.println("Number of small: " + totSmall);
				
			}
			
		});
		// Creating medium size coffee buttons
		Button btn2 = new Button();
		btn2.setText("Press for 1 Medium Coffee");
		btn2.setLayoutX(50);
		btn2.setLayoutY(250);
		btn2.setOnAction(new EventHandler<ActionEvent> () {
			
			@Override
			public void handle(ActionEvent event) {
				totMed++;
				System.out.println("Number of medium: " + totMed);
				
			}
			
		});
		// Creating large size coffee buttons
				Button btn3 = new Button();
				btn3.setText("Press for 1 Medium Coffee");
				btn3.setLayoutX(50);
				btn3.setLayoutY(300);
				btn3.setOnAction(new EventHandler<ActionEvent> () {
					
					@Override
					public void handle(ActionEvent event) {
						totLarge++;
						System.out.println("Number of large: " + totLarge);
						
					}
					
				});
				
		// Selection for cream button	
				Button cream = new Button();
				cream.setText("Press to add cream");
				cream.setLayoutX(350);
				cream.setLayoutY(200);
				cream.setOnAction(new EventHandler<ActionEvent> () {
					
					@Override
					public void handle(ActionEvent event) {
						creamC++;
						System.out.println("# of cream: " + creamC);
						
					}
					
				});
		// Selection for rawSugar button	
				Button rawS = new Button();
				rawS.setText("Press to add raw sugar");
				rawS.setLayoutX(330);
				rawS.setLayoutY(250);
				rawS.setOnAction(new EventHandler<ActionEvent> () {
					
					@Override
					public void handle(ActionEvent event) {
						rawSugarC++;
						System.out.println("# of rawSugar: " + rawSugarC);
						
					}
					
				});				
		// Selection for rawSugar button	
				Button shot = new Button();
				shot.setText("Press to add shots");
				shot.setLayoutX(355);
				shot.setLayoutY(300);
				shot.setOnAction(new EventHandler<ActionEvent> () {
					
					@Override
					public void handle(ActionEvent event) {
						espressoShotC++;
						System.out.println("# of shots: " + espressoShotC);
						
					}
					
				});			
				
>>>>>>> fbe5ec39a3b772349c73cd9b82c315540759849b
		// Retrieving the observable list object
		ObservableList list = root.getChildren();

		// Setting the text object as a node to the group object
		list.add(text);
<<<<<<< HEAD
		list.add(tf);
		list.add(b);

		// Creating a scene object
		Scene scene = new Scene(root, 600, 600);
=======
		list.add(textField);
		list.add(btn);
		list.add(btn2);
		list.add(btn3);
		list.add(cream);
		list.add(rawS);
		list.add(shot);

		// Creating a scene object
		Scene scene = new Scene(root, 800, 600);
>>>>>>> fbe5ec39a3b772349c73cd9b82c315540759849b

		// Setting title to the Stage
		primaryStage.setTitle("Sample Application");

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();
	}
<<<<<<< HEAD
	
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
=======
>>>>>>> fbe5ec39a3b772349c73cd9b82c315540759849b
}
