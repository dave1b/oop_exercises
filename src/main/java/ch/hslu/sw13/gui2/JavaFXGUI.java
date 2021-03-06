package ch.hslu.sw13.gui2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public final class JavaFXGUI extends Application {

	private static final Logger LOG = LogManager.getLogger(JavaFXGUI.class);

	@Override
	public void start(final Stage primaryStage) {

		primaryStage.setTitle("Switch GUI with JavaFX");
		final Label label = new Label("The switch is OFF.");

		final Button btnOn = new Button("On");
		btnOn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {
				label.setText("The switch is ON.");
				label.setStyle("-fx-background-color: lightgreen;");
				LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
			}
		});
		final Button btnOff = new Button("Off");
		btnOff.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {
				label.setText("The switch is OFF.");
				label.setStyle("-fx-background-color: red;");
				LOG.info("ActionEvent von OFF-Button empfangen und verarbeitet.");
			}
		});

		final BorderPane borderPane = new BorderPane();
		borderPane.setTop(btnOn);
		borderPane.setCenter(label);
		borderPane.setBottom(btnOff);
		primaryStage.setScene(new Scene(borderPane, 200, 100));
		primaryStage.show();
		LOG.info("GUI-Stage aktiviert und sichtbar.");
	}

	/**
	 * main-Methode startet die JavaFX-Application.
	 * @param args nicht verwendet.
	 */
	public static void main(final String[] args) {
		LOG.info("Applikation startet...");
		launch(JavaFXGUI.class, args);
	}
}







