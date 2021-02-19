package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Iterator;


public class UI extends Application {

	CoffeePot coffeePot;

	Button powerButton = new Button("Power");
	Button regBrewButton = new Button ("Regular Brew");
	Button strBrewButton = new Button ("Strong Brew");
	Button addGroundsButton = new Button ("Add Coffee");
	Button addWaterButton = new Button ("Fill Water");
	Button brewButton = new Button ("Start Brew");

	Circle powerLight = new Circle(10);
	Circle hasGroundsLight = new Circle(10);
	Circle hasWaterLight = new Circle(10);
	Circle strBrewLight = new Circle(10);
	Circle regBrewLight = new Circle(10);
	Circle brewLight = new Circle(10);

	TextArea display;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		coffeePot = new CoffeePot(false, false);

		stage.getIcons().add(new Image("file:coffeePot.png"));
		stage.setTitle("Coffee Pot: State Pattern");

		stage.centerOnScreen();

		display = new TextArea();
		display.setDisable(true);
		display.setStyle("-fx-opacity: 1;");
		display.setWrapText(true);

		powerLight.setStrokeWidth(2);
		powerLight.setStroke(Color.BLACK);

		hasGroundsLight.setStrokeWidth(2);
		hasGroundsLight.setStroke(Color.BLACK);

		hasWaterLight.setStrokeWidth(2);
		hasWaterLight.setStroke(Color.BLACK);

		strBrewLight.setStrokeWidth(2);
		strBrewLight.setStroke(Color.BLACK);

		regBrewLight.setStrokeWidth(2);
		regBrewLight.setStroke(Color.BLACK);

		brewLight.setStrokeWidth(2);
		brewLight.setStroke(Color.BLACK);

		powerButton.setMaxWidth(90);
		regBrewButton.setMaxWidth(90);
		strBrewButton.setMaxWidth(90);   
		addGroundsButton.setMaxWidth(90);
		addWaterButton.setMaxWidth(90);
		brewButton.setMaxWidth(90);


		powerButton.setMinWidth(90);
		regBrewButton.setMinWidth(90);
		strBrewButton.setMinWidth(90);   
		addGroundsButton.setMinWidth(90);
		addWaterButton.setMinWidth(90);
		brewButton.setMinWidth(90);

		HBox hbPower = new HBox();
		hbPower.setSpacing(10);
		hbPower.setPadding(new Insets(0, 10, 10, 10)); 
		hbPower.getChildren().addAll(this.powerLight, this.powerButton);
		hbPower.setAlignment(Pos.CENTER);;

		HBox hbGrounds = new HBox();
		hbGrounds.setSpacing(10);
		hbGrounds.setPadding(new Insets(0, 10, 10, 10)); 
		hbGrounds.getChildren().addAll(this.hasGroundsLight, this.addGroundsButton);
		hbGrounds.setAlignment(Pos.CENTER);;

		HBox hbWater = new HBox();
		hbWater.setSpacing(10);
		hbWater.setPadding(new Insets(0, 10, 10, 10)); 
		hbWater.getChildren().addAll(this.hasWaterLight, this.addWaterButton);
		hbWater.setAlignment(Pos.CENTER);;

		VBox buttons1 = new VBox();
		buttons1.setSpacing(10);
		buttons1.setPadding(new Insets(20, 20, 10, 20)); 
		buttons1.getChildren().addAll(hbPower, hbGrounds, hbWater);

		HBox hbBrew = new HBox();
		hbBrew.setSpacing(10);
		hbBrew.setPadding(new Insets(0, 10, 10, 10)); 
		hbBrew.getChildren().addAll(this.brewLight, this.brewButton);
		hbBrew.setAlignment(Pos.CENTER);;

		HBox hbRegBrew = new HBox();
		hbRegBrew.setSpacing(10);
		hbRegBrew.setPadding(new Insets(0, 10, 10, 10)); 
		hbRegBrew.getChildren().addAll(this.regBrewLight, this.regBrewButton);
		hbRegBrew.setAlignment(Pos.CENTER);;

		HBox hbStrBrew = new HBox();
		hbStrBrew.setSpacing(10);
		hbStrBrew.setPadding(new Insets(0, 10, 10, 10)); 
		hbStrBrew.getChildren().addAll(this.strBrewLight, this.strBrewButton);
		hbStrBrew.setAlignment(Pos.CENTER);;

		VBox buttons2 = new VBox();
		buttons2.setSpacing(10);
		buttons2.setPadding(new Insets(20, 20, 10, 20)); 
		buttons2.getChildren().addAll(hbBrew, hbRegBrew, hbStrBrew);

		HBox buttons = new HBox();
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(0, 10, 10, 10)); 
		buttons.getChildren().addAll(buttons1,buttons2);
		buttons.setAlignment(Pos.CENTER);;

		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(20, 20, 10, 20)); 
		vBox.getChildren().addAll(display, buttons);

		powerButton.setOnAction(event -> {
			coffeePot.getState().power();
			updateButtons();
			displayMessages();
		});

		this.addGroundsButton.setOnAction(event -> {
			coffeePot.getState().addCoffee();;
			updateButtons();
			displayMessages();
		});

		this.addWaterButton.setOnAction(event -> {
			coffeePot.getState().addWater();;
			updateButtons();
			displayMessages();
		});

		brewButton.setOnAction(event -> {
			new Thread(){
				public void run(){
					coffeePot.getState().startBrew();
					updateButtons();
					displayMessages();		          
				}
			}.start();
			try {
				Thread.sleep(100);
				updateButtons();
				displayMessages();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		strBrewButton.setOnAction(event -> {
			coffeePot.getState().setStrongBrew();;
			updateButtons();
			displayMessages();
		});

		regBrewButton.setOnAction(event -> {
			coffeePot.getState().setRegularBrew();;
			updateButtons();
			displayMessages();
		});

		Scene scene = new Scene(vBox, 450, 300);
		stage.setScene(scene);
		updateButtons();
		stage.show();
	}

	public void updateButtons() {
		if (coffeePot.isPowerOn())
			powerLight.setFill(Color.GREEN);
		else
			powerLight.setFill(Color.RED);

		if (coffeePot.getHasGrounds())
			this.hasGroundsLight.setFill(Color.GREEN);
		else
			this.hasGroundsLight.setFill(Color.RED);

		if (coffeePot.getHasWater())
			this.hasWaterLight.setFill(Color.GREEN);
		else
			this.hasWaterLight.setFill(Color.RED);

		if (coffeePot.isStrongBrew()) {
			this.strBrewLight.setFill(Color.GREEN);
			this.regBrewLight.setFill(Color.RED);
		} else {
			this.strBrewLight.setFill(Color.RED);
			this.regBrewLight.setFill(Color.GREEN);
		}
		if (coffeePot.isBrewing())
			this.brewLight.setFill(Color.GREEN);
		else
			this.brewLight.setFill(Color.RED);

	}

	public void displayMessages () {
		Iterator<String> iter = coffeePot.messagesIterator();
		if (iter.hasNext())
			display.clear();
		while (iter.hasNext()) {
			display.setText(display.getText() + iter.next());
			iter.remove();
		}		
	}

}