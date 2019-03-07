package Pack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CoffeeShoppeGUI extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Jim Coffee Shoppe");
		
		Button btn = new Button();
		Label label1 = new Label();
		TextField textField = new TextField ();
		HBox hb = new HBox();
		
		btn.setText("Test button 1");
		btn.setOnAction(new EventHandler<ActionEvent> () {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("This is the action of the button");
			}
			
		});
		
		hb.getChildren().addAll(label1, textField);
		hb.setSpacing(10);
		
		
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
		
	}
}











































