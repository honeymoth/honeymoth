package ru.spbu.arts.java.oop.javafx;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Messenger extends Application {
    private Button commitButton;
    private TextArea msgWindow;
    private TextField inputField;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Messenger");

        Parent parent = initInterface();
        stage.setScene(new Scene(parent));
        interaction();

        stage.show();
    }

    private Parent initInterface() {
        HBox base = new HBox();

        VBox textBase = new VBox();
        msgWindow = new TextArea();

        HBox inputBase = new HBox();
        inputField = new TextField("Input your message");
        commitButton = new Button("send");

        VBox contactsBase = new VBox();
        Label heading = new Label("Your contacts");
        ObservableList<String> contacts = FXCollections.observableArrayList("My beloved cat", "mom", "dad", "bff<3");
        ListView<String> contactsList = new ListView<>(contacts);



        base.setStyle("-fx-background-color: #f0b33a");
        inputBase.setStyle("-fx-background-color: #273961;");
        textBase.setStyle("-fx-background-color: #0b1d55");
        contactsBase.setStyle("-fx-background-color: #5e88aa");

        inputBase.getChildren().addAll(inputField, commitButton);
        textBase.getChildren().addAll(msgWindow, inputBase);

        contactsBase.getChildren().addAll(heading, contactsList);

        base.getChildren().addAll(textBase, contactsBase);
        //for msg half
        VBox.setVgrow(msgWindow, Priority.ALWAYS);
        HBox.setHgrow(inputField, Priority.ALWAYS);
        HBox.setHgrow(textBase, Priority.ALWAYS);
        commitButton.setPrefSize(150,30);
        inputField.setPrefHeight(30);
        //for contacts half
        VBox.setVgrow(contactsList, Priority.ALWAYS);

        contactsBase.setPrefWidth(300);
        heading.setPrefSize(300,30);


        return base;
    }

    private void interaction(){
        msgWindow.setDisable(true);
        commitButton.addEventHandler(ActionEvent.ACTION, event -> {
            msgWindow.appendText("\n"+ inputField.getText());
            inputField.clear();
        });
    }
}
