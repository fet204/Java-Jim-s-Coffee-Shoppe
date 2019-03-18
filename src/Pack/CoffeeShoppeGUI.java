package Pack;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Optional;

public class CoffeeShoppeGUI extends Application {

    //region to intialize variables
    //Declaring a new decimal format cause it's annoying me
    static DecimalFormat df = new DecimalFormat("#.##");
    //List root getter
    ObservableList<javafx.scene.Node> list;
    //Counting the amount of orders
    private static int totSmall = 0;
    private static int totMed = 0;
    private static int totLarge = 0;
    private static double totSum = 0;
    // initializing the values for the extras button
    private static int creamC = 0;
    private static int rawSugarC = 0;
    private static int espressoShotC = 0;
    private static String computeName = "";
    private static Text text;
    private static TextField tf;
    //Do texts for the order numbers
    private static Text smallT, medT, bigT;
    private static Text creamT, sugarT, espressoT;
    //Button declaration
    private static Button b, btn, btn2, btn3, cream, rawS, shot, compute, sB;
    private static Button subSmall, subMed, subLarge, subCream, subSugar,subShot;
    // Initializing values for the buttons
    private static double small = 1.25;
    private static double med = 1.75;
    private static double large = 2.30;
    private static double eP = 0.75;
    //endregion

    public static void main(String[] args) {
        launch(args);
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

    private static void showComputeDialog() {

        df.setRoundingMode(RoundingMode.CEILING);

        Alert computeAlert = new Alert(AlertType.INFORMATION);
        computeAlert.setWidth(400);
        computeAlert.setHeight(400);
        computeAlert.setTitle("Receipt");
        computeAlert.setHeaderText(null);
        computeAlert.setContentText(


        		// Temp block off so i can make some if statements

        		"Hey there " + computeName + "\n"
                + "Here is your order:\n"
                + "You ordered " + totSmall + " amounts of small coffee\n"
                + "You ordered " + totMed + " amounts of medium coffee\n"
                + "You ordered " + totLarge + " amounts of large coffee\n"

                + "\n\n"
                + "You ordered " + creamC + " amounts of cream\n"
                + "You ordered " + rawSugarC + " amounts of Sugar\n"
                + "You ordered " + espressoShotC + " amounts of Espresso Shot"
                +


        		//IF STATEMENTS



                "\n\n\n\n For a grand total of: $" + df.format(totSum));

        computeAlert.showAndWait();
    }

    private static void formatbtn(){
        smallT.setX(270);
        smallT.setY(230);
        smallT.setFont(new Font(20));
        smallT.setVisible(false);
        btn.setMinSize(156, 50);
        btn.setText("Small Coffee: $1.25");
        btn.setLayoutX(100);
        btn.setLayoutY(200);
    }

    private static void formatbtn2(){
        medT.setX(smallT.getX());
        medT.setY(281);
        medT.setFont(new Font(20));
        medT.setVisible(false);
        btn2.setMinSize(156, 50);
        btn2.setText("Medium Coffee: $1.75");
        btn2.setLayoutX(btn.getLayoutX());
        btn2.setLayoutY(250);
    }

    private static void formatbtn3(){
        bigT.setX(medT.getX());
        bigT.setY(330);
        bigT.setFont(new Font(20));
        bigT.setVisible(false);
        btn3.setMinSize(156, 50);
        btn3.setText("Large Coffee: $2.30");
        btn3.setLayoutX(btn2.getLayoutX());
        btn3.setLayoutY(300);
    }

    private static void formatCream(){
        creamT.setFont(new Font(20));
        creamT.setX(580);
        creamT.setY(smallT.getY());
        creamT.setVisible(false);
        cream.setMinSize(156, 50);
        cream.setText("Cream: Free");
        cream.setLayoutX(400);
        cream.setLayoutY(200);
    }

    private static void formatSugar(){
        sugarT.setFont(new Font(20));
        sugarT.setX(creamT.getX());
        sugarT.setY(medT.getY());
        sugarT.setVisible(false);
        rawS.setMinSize(156, 50);
        rawS.setText("Raw sugar: Free");
        rawS.setLayoutX(cream.getLayoutX());
        rawS.setLayoutY(250);
    }

    private static void formatEspresso(){
        espressoT.setFont(new Font(20));
        espressoT.setX(creamT.getX());
        espressoT.setY(bigT.getY());
        shot.setMinSize(156, 50);
        shot.setText("Extra shots: $0.75");
        shot.setLayoutX(cream.getLayoutX());
        shot.setLayoutY(300);
    }

    private static void formatCompute(){
        compute.setText("COMPUTE");
        compute.setLayoutX(350);
        compute.setLayoutY(400);
    }

    private static void showScene(Stage primaryStage, Group root){
        Scene scene = new Scene(root, 800, 600);

        // Adding scene to the stage
        primaryStage.setScene(scene);

        // Displaying the contents of the stage
        primaryStage.show();
    }

    private static void formatSB(){
        sB.setMinSize(150, 150);
        sB.setLayoutX(550);
        sB.setLayoutY(400);
    }

    private static void subtractAmount(Button name){
        if(name.equals(subSmall)){
            totSmall--;
            totSum -= small;
            updateButtons(totSmall, smallT);
        }
        if (name.equals(subMed)) {
            totMed--;
            totSum -= med;
            updateButtons(totMed, medT);
        }
        if(name.equals(subLarge)){
            totLarge --;
            totSum -= large;
            updateButtons(totLarge, bigT);
        }
        if(name.equals(subCream)){
            creamC--;
            updateButtons(creamC, creamT);
        }
        if(name.equals(subSugar)){
            rawSugarC--;
            updateButtons(rawSugarC, sugarT);
        }
        if(name.equals(subShot)){
            espressoShotC--;
            totSum -= eP;
            updateButtons(espressoShotC, espressoT);
        }
    }

    private static void updateButtons(int i, Text tf){
        tf.setText(Integer.toString(i));
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Jim Coffee Shoppe");

        // Creating a Group object
        Group root = new Group();
        list = root.getChildren();

        // Button for name change
        //region for the name button
        Button b = new Button("Want to change your name?");
        b.setTranslateX(300);
        b.setTranslateY(75);
        b.setVisible(false);

        // Make a text field object
        tf = new TextField("Enter name here");

        // Creating a Text object
        text = new Text();

        new Label("Name:");

        // Setting font to the text
        text.setFont(new Font(45));

        //Make an action event for the name change
        System.out.println(tf.getText());
        tf.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                b.setVisible(true);
                tf.setVisible(false);
                changeText(tf.getText(), text);
                computeName = tf.getText();
            }
        });

        b.setOnAction(event -> showInputDialog(text));

        text.setX(275);
        text.setY(50);
        //endregion

        //region for small coffe button
        // Creating small coffee button options
        btn = new Button();
        smallT = new Text();
        formatbtn();
        btn.setOnAction(event -> {
            totSmall++;
            totSum += small;
            System.out.println("Number of small: " + totSmall);
            smallT.setText(Integer.toString(totSmall));
            smallT.setVisible(true);
        });
        //endregion

        //region for medium button
        // Creating medium size coffee buttons
        btn2 = new Button();
        medT = new Text();
        formatbtn2();
        btn2.setOnAction(event -> {
            totMed++;
            totSum += med;
            System.out.println("Number of medium: " + totMed);
            medT.setText(Integer.toString(totMed));
            medT.setVisible(true);
        });
        //endregion

        //region for big coffee button
        // Creating large size coffee buttons
        btn3 = new Button();
        bigT = new Text();
        formatbtn3();
        btn3.setOnAction(event -> {
            totLarge++;
            totSum += large;
            System.out.println("Number of large: " + totLarge);
            bigT.setText(Integer.toString(totLarge));
            bigT.setVisible(true);
        });
        //endregion

        //region for cream buton
        // Selection for cream button
        cream = new Button();
        creamT = new Text();
        formatCream();
        cream.setOnAction(event -> {
            creamC++;
            System.out.println("# of cream: " + creamC);
            creamT.setText(Integer.toString(creamC));
            creamT.setVisible(true);
        });
        //endregion

        //region for add sugar button
        rawS = new Button();
        sugarT = new Text();
        formatSugar();
        rawS.setOnAction(event -> {
            rawSugarC++;
            System.out.println("# of rawSugar: " + rawSugarC);
            sugarT.setText(Integer.toString(rawSugarC));
            sugarT.setVisible(true);
        });
        //endregion

        //region to add espresso shots
        shot = new Button();
        espressoT = new Text();
        formatEspresso();
        shot.setOnAction(event -> {
            espressoShotC++;
            totSum += eP;
            System.out.println("# of shots: " + espressoShotC);
            espressoT.setText(Integer.toString(espressoShotC));
            espressoT.setVisible(true);
        });
        //endregion

        //region Region to compute the total
        // Selection for compute button
        compute = new Button();
        compute.setMinSize(150, 150);
        formatCompute();
        compute.setOnAction(event -> {
            System.out.println("total sum: " + totSum);
            showComputeDialog();
        });
        //endregion

        //region to close the app
        //Button to close the entire program
        sB = new Button("Click here to close");
        formatSB();
        sB.setOnAction(event -> Platform.exit());
        //endregion

        //<-------------------------Subtract Buttons----------------------->\\
        subSmall = new Button("-");
        subSmall.setFont(new Font(20));
        subSmall.setLayoutX(btn.getLayoutX()-40);
        subSmall.setLayoutY(btn.getLayoutY());
        subSmall.setOnAction((event) -> {
            if(totSmall > 0){
                subtractAmount(subSmall);
            }
        });

        subMed = new Button("-");
        subMed.setFont(new Font(20));
        subMed.setLayoutX(subSmall.getLayoutX());
        subMed.setLayoutY(btn2.getLayoutY());
        subMed.setOnAction((event) -> {
            if(totMed > 0){
                subtractAmount(subMed);
            }
        });

        subLarge = new Button("-");
        subLarge.setFont(new Font(20));
        subLarge.setLayoutX(subMed.getLayoutX());
        subLarge.setLayoutY(btn3.getLayoutY());
        subLarge.setOnAction(actionEvent -> {
            if(totLarge > 0){
                subtractAmount(subLarge);
            }
        });

        subSugar = new Button("-");
        subSugar.setFont(new Font(20));
        subSugar.setLayoutX(rawS.getLayoutX() - 40);
        subSugar.setLayoutY(rawS.getLayoutY());
        subSugar.setOnAction(actionEvent -> {
            if(rawSugarC > 0){
                subtractAmount(subSugar);
            }
        });

        subCream = new Button("-");
        subCream.setFont(new Font(20));
        subCream.setLayoutX(subSugar.getLayoutX());
        subCream.setLayoutY(cream.getLayoutY());
        subCream.setOnAction(actionEvent -> {
            if(creamC > 0){
                subtractAmount(subCream);
            }
        });

        subShot = new Button("-");
        subShot.setFont(new Font(20));
        subShot.setLayoutX(subCream.getLayoutX());
        subShot.setLayoutY(shot.getLayoutY());
        subShot.setOnAction(actionEvent -> {
            if(espressoShotC > 0){
                subtractAmount(subShot);
            }
        });

        //region to add lists and stuff
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
        list.add(smallT);
        list.add(medT);
        list.add(bigT);
        list.add(creamT);
        list.add(espressoT);
        list.add(sugarT);
        list.add(subSmall);
        list.add(subMed);
        list.add(subLarge);
        list.add(subSugar);
        list.add(subShot);
        list.add(subCream);
        //endregion

        showScene(primaryStage, root);
    }
}
