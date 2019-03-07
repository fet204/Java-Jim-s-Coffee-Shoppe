package Pack;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
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
		
		Label label1 = new Label("Name:");
		TextField textField = new TextField ();
		textField.setText("Name here");
		textField.getText();
		
		
	    //Creating a Text object 
	      Text text = new Text(); 
	       
	      //Setting font to the text 
	      text.setFont(new Font(45)); 
	       
	      //setting the position of the text 
	      text.setX(50); 
	      text.setY(150);          
	      
	      //Setting the text to be added. 
	      text.setText("Welcome " ); 
	         
	      //Creating a Group object  
	      Group root = new Group(); 
	       
	      //Retrieving the observable list object 
	      ObservableList list = root.getChildren(); 
	       
	      //Setting the text object as a node to the group object 
	      list.add(text);
	      list.add(textField);
	               
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600,600); 
	       
	      //Setting title to the Stage 
	      primaryStage.setTitle("Sample Application"); 
	         
	      //Adding scene to the stage 
	      primaryStage.setScene(scene); 
	         
	      //Displaying the contents of the stage 
	      primaryStage.show(); 
	   } 
}











































