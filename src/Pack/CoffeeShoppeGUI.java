package Pack;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoffeeShoppeGUI extends Application {

	String result;
	Text text;
	TextField tf;
	// Initializing values for the buttons
	double small = 1.25;
	double med = 1.75;
	double large = 2.30;
	
	static int totSmall = 0;
	static int totMed = 0;
	static int totLarge = 0;
	
	static double totSum = 0;
	
	// initializing the values for the extras button
	int creamC = 0;
	int rawSugarC = 0;
	int espressoShotC = 0;
	double eP = 0.75;
	
	static String computeName = "";
	
	//Declareing a new decimal format cause it's annoying me
	static DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Jim Coffee Shoppe");

		// Button for name change
		Button b = new Button("Want to change your name?");
		b.setTranslateX(300);
		b.setTranslateY(75);
		b.setVisible(false);

		// Make a text field object
		tf = new TextField("Enter name here");

		// Creating a Text object
		text = new Text();

		Label label1 = new Label("Name:");

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
					computeName = tf.getText();
				}
			}
		});

		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showInputDialog(text);
			}
		});

		text.setX(275);
		text.setY(50);

		// Creating a Group object
		Group root = new Group();

		// Creating small coffee button options
		Button btn = new Button();
		Text smallT = new Text();
		smallT.setX(165);
		smallT.setY(50);
		smallT.setVisible(false);
		btn.setMinSize(156, 50);
		btn.setText("Small Coffee: $1.25");
		btn.setLayoutX(50);
		btn.setLayoutY(200);
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				totSmall++;
				totSum += small;
				System.out.println("Number of small: " + totSmall);
				smallT.setVisible(true);
			}

		});
		// Creating medium size coffee buttons
		Button btn2 = new Button();
		btn2.setMinSize(156, 50);
		btn2.setText("Medium Coffee: $1.75");
		btn2.setLayoutX(50);
		btn2.setLayoutY(250);
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				totMed++;
				totSum += med;
				System.out.println("Number of medium: " + totMed);

			}

		});
		// Creating large size coffee buttons
		Button btn3 = new Button();
		btn3.setMinSize(156, 50);
		btn3.setText("Large Coffee: $2.30");
		btn3.setLayoutX(50);
		btn3.setLayoutY(300);
		btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				totLarge++;
				totSum += large;
				System.out.println("Number of large: " + totLarge);

			}

		});

		// Selection for cream button
		Button cream = new Button();
		cream.setMinSize(156, 50);
		cream.setText("Cream: Free");
		cream.setLayoutX(346);
		cream.setLayoutY(200);
		cream.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				creamC++;
				System.out.println("# of cream: " + creamC);

			}

		});
		// Selection for rawSugar button
		Button rawS = new Button();
		rawS.setMinSize(156, 50);
		rawS.setText("Raw sugar: Free");
		rawS.setLayoutX(346);
		rawS.setLayoutY(250);
		rawS.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				rawSugarC++;
				System.out.println("# of rawSugar: " + rawSugarC);

			}

		});
		// Selection for shot button
		Button shot = new Button();
		shot.setMinSize(156, 50);
		shot.setText("Extra shots: $0.75");
		shot.setLayoutX(346);
		shot.setLayoutY(300);
		shot.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				espressoShotC++;
				totSum += eP;
				System.out.println("# of shots: " + espressoShotC);

			}

		});
		
		// Selection for compute button
				Button compute = new Button();
				compute.setMinSize(150, 150);
				compute.setText("COMPUTE");
				compute.setLayoutX(350);
				compute.setLayoutY(400);
				compute.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						espressoShotC++;
						System.out.println("total sum: " + totSum);
						showComputeDialog();
					}

				});
		
		//Button to close the entire program
		Button sB = new Button("Click here to close");
		sB.setMinSize(150, 150);
		sB.setLayoutX(550);
		sB.setLayoutY(400);
		sB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		// Retrieving the observable list object
		ObservableList list = root.getChildren();
		


		// Setting the text object as a node to the group object
		list.add(text);
		list.add(tf);
		list.add(b);

		list.add(btn);
		list.add(btn2);
		list.add(btn3);
		list.add(cream);
		list.add(rawS);
		list.add(shot);
		list.add(compute);
		list.add(sB);

		// Creating a scene object
		Scene scene = new Scene(root, 800, 600);

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
		
		computeName = trueResult;
	}

	private static void changeText(String result, Text t) {
		t.setText("Welcome " + result);
	}
	
	public static void showComputeDialog(){

		df.setRoundingMode(RoundingMode.CEILING);
		
		Alert computeAlert = new Alert(AlertType.INFORMATION);
		computeAlert.setWidth(400);
		computeAlert.setHeight(400);
		computeAlert.setTitle("Receipt");
		computeAlert.setHeaderText(null);
		computeAlert.setContentText("Here is your order!:\n"
				+ "You ordered " + totSmall + " amounts of small cofee\n"
				+ "You ordered " + totMed + " amounts of medium cofee\n"
				+ "You ordered " + totLarge + " amounts of large cofee\n"
				+ "\n\n\n\n For a grand total of: $"+df.format(totSum));
		
		computeAlert.showAndWait();
	}
}
