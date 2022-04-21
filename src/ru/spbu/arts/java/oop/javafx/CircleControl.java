package ru.spbu.arts.java.oop.javafx;

import javafx.application.Application;

import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleControl extends Application {

    private Slider RadiusControl;
    private Circle circle;
    private Pane CircleBackGround;
    private ColorPicker CircleColor;
    private ColorPicker BackGroundColor;

    @Override
    public void start(Stage stage){
        stage.setTitle("Circle manipulator");

        Parent parent = initInterface();
        stage.setScene(new Scene(parent));
        interaction();

        stage.show();
    }

    private Parent initInterface(){

        GridPane base = new GridPane();

        GridPane SliderBase = new GridPane();
        Pane SliderBackGround = new Pane();
        RadiusControl = new Slider();
        CircleColor = new ColorPicker();
        BackGroundColor = new ColorPicker();
        Label l1 = new Label("Радиус");
        Label l2 = new Label("Цвет круга");
        Label l3 = new Label("Цвет фона");

        GridPane CircleBase = new GridPane();
        CircleBackGround = new Pane();
        circle = new Circle();

        SliderBase.setStyle("-fx-background-color: #BA97E0");
        CircleBase.setStyle("-fx-background-color: #BDE097");
        SliderBackGround.setStyle("-fx-background-color: #C7C9CB");
        CircleBackGround.setStyle("-fx-background-color: #E2E3E4");


        SliderBase.add(SliderBackGround,0,0,3,7);
        SliderBase.add(l1,1,0);
        SliderBase.add(RadiusControl,1,1);
        SliderBase.add(l2,1,2);
        SliderBase.add(CircleColor,1,3);
        SliderBase.add(l3,1,4);
        SliderBase.add(BackGroundColor,1,5);

        CircleBackGround.getChildren().add(circle);
        CircleBase.add(CircleBackGround, 0,0,2,2);

        base.add(SliderBase, 0, 0,1,2);
        base.add(CircleBase, 1,0,1,2);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPrefWidth(300);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setHgrow(Priority.ALWAYS);

        base.getColumnConstraints().addAll(c1,c2);
        SliderBase.getColumnConstraints().addAll(c2,c2,c2);
        CircleBase.getColumnConstraints().addAll(c2,c2);

        RowConstraints r = new RowConstraints();
        r.setVgrow(Priority.ALWAYS);

        RowConstraints lc = new RowConstraints();
        lc.setPrefHeight(50);
        RowConstraints sc = new RowConstraints();
        sc.setMaxHeight(80);
        RowConstraints cc = new RowConstraints();
        cc.setMaxHeight(60);


        base.getRowConstraints().addAll(r, r);
        SliderBase.getRowConstraints().addAll(lc,sc,lc,cc,lc,cc,r);
        CircleBase.getRowConstraints().add(r);
        base.setPrefSize(1000,700);


        return base;
    }

    private void interaction(){
        circle.radiusProperty().bind(
                RadiusControl.valueProperty()
        );
        circle.centerXProperty().bind(
                Bindings.divide(CircleBackGround.widthProperty(),2)
        );
        circle.centerYProperty().bind(
                Bindings.divide(CircleBackGround.heightProperty(),2)
        );
        circle.fillProperty().bind(
                CircleColor.valueProperty()
        );
        RadiusControl.maxProperty().bind(
                Bindings.divide(CircleBackGround.widthProperty(),2)
        );
        RadiusControl.maxProperty().bind(
                Bindings.divide(CircleBackGround.heightProperty(),2)
        );
    }
}
