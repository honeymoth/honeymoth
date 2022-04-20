package ru.spbu.arts.java.oop.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class DontPressThisButton extends Application {

    private Button PatientButton;

    private int ClickCount = 0;

    private ImageView ScaryPic;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Don't press any buttons");
        Parent parent = InitInterface();

        stage.setScene(new Scene(parent));
        interaction();

        stage.show();
    }

    private Parent InitInterface() {
        VBox base = new VBox();
        PatientButton = new Button("не нажимайте эту кнопку");
        ScaryPic = new ImageView();
        Image pic = new Image("ru/spbu/arts/java/oop/javafx/scary.jpg");
        ScaryPic.setImage(pic);

        base.getChildren().addAll(PatientButton, ScaryPic);

        PatientButton.setMaxSize(900, 150);
        PatientButton.setLayoutY(300);
        PatientButton.setStyle("-fx-font-size: 22px");
        base.setAlignment(Pos.CENTER);
        base.setPrefSize(1000, 700);
        ScaryPic.setFitWidth(600);
        ScaryPic.setPreserveRatio(true);
        ScaryPic.setSmooth(true);

        ScaryPic.setVisible(false);

        return base;
    }

    private void interaction() {
        List<String> warnings = List.of("не нажимайте эту кнопку", "пожалуйста, не нажимайте больше эту кнопку", "почему вы снова нажали?", "НЕ НАЖИМАЙТЕ", "ПРЕКРАТИТЕ","...","готовы ли вы принять последствия своих решений?","ЭТО ВАШ ПОСЛЕДНИЙ ШАНС ПРЕКРАТИТЬ НАЖИМАТЬ НА ЭТУ КНОПКУ");
        PatientButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            ClickCount++;
            if (ClickCount < 8) {
                PatientButton.setText(warnings.get(ClickCount));
            } else{
                PatientButton.setVisible(false);
                ScaryPic.setVisible(true);

            }
        });
    }
}
