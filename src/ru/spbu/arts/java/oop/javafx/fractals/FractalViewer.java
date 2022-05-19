package ru.spbu.arts.java.oop.javafx.fractals;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FractalViewer  extends Application {
    public final static int W = 600;
    public final static int H = 500;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Просмотр фигур");

        Pane root = initInterface();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private Pane initInterface(){
        WritableImage image = new WritableImage(W,H);
        Display display = new Display(-4,5,8/600.0);
        Fractal f = new Mandelbrot();
        display.paint(image, f);

        ImageView view = new ImageView(image);
        return new Pane(view);
    }
}
