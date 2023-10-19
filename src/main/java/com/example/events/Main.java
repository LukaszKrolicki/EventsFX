package com.example.events;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Label label = new Label("This is label");
        Button button = new Button("Click");

        button.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> label.setText("Thank you!"));
        //it will change label text but only when mouse clicked

        root.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent ->mouseEvent.consume());
        //the event will be consumed and will not be executed

        button.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent ->{
            if(keyEvent.getCode() == KeyCode.X) {
                label.setText("Thank you!");
            }
        });

        stage.setOnShowing(windowEvent -> System.out.println("Stage is showed"));
        root.getChildren().addAll(label,button);
        Scene scene = new Scene(root,500,500);
        scene.setOnMouseMoved(mouseEvent -> label.setText("X: "+ mouseEvent.getX() +" y: "+ mouseEvent.getY()));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
