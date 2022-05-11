package ru.spbu.arts.java.oop.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawingImages extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Images print");

        Parent parent = initInterface();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private Parent initInterface() {

        WritableImage favColor = new WritableImage(100, 100);
        PixelWriter brush = favColor.getPixelWriter();
        for (int x = 0; x < 100; ++x) {
            for (int y = 0; y < 100; ++y) {
                brush.setColor(x, y, Color.MEDIUMSEAGREEN);
            }
        }
        WritableImage cordsRGB = new WritableImage(256, 256);
        PixelWriter rgbWriter = cordsRGB.getPixelWriter();
        for (int x = 0; x < 256; ++x) {
            for (int y = 0; y < 256; ++y) {
                rgbWriter.setColor(x, y, Color.rgb(x, y, 190));
            }
        }
        WritableImage cordsHSB = new WritableImage(360, 100);
        PixelWriter hsbWriter = cordsHSB.getPixelWriter();
        for (int x = 0; x < 360; ++x) {
            for (int y = 0; y < 100; ++y) {
                double s = y * 1.0;
                hsbWriter.setColor(x, y, Color.hsb(x, s / 100, 0.9));
            }
        }
        WritableImage square = new WritableImage(100, 100);
        PixelWriter squareWriter = square.getPixelWriter();
        for (int x = 25; x < 75; ++x) {
            for (int y = 25; y < 75; ++y) {
                squareWriter.setColor(x, y, Color.BLACK);
            }
        }
        WritableImage circle = new WritableImage(100, 100);
        PixelWriter circleWriter = square.getPixelWriter();
        int r = 49;
        for (int x = 0; x < 100; ++x) {
            for (int y = 0; y < 100; ++y) {
                if ((x - 50) * (x - 50) + (y - 50) * (y - 50) < r * r) {
                    circleWriter.setColor(x, y, Color.WHITE);
                } else {
                    circleWriter.setColor(x, y, Color.BLACK);
                }
            }
        }
        WritableImage cordsLHC = new WritableImage(360, 100);
        PixelWriter LHCWriter = cordsLHC.getPixelWriter();
        for (int x = 0; x < 360; ++x) {
            for (int y = 0; y < 100; ++y) {
                double l = x * 1.0;
                double c = y * 1.0;
                LHCWriter.setColor(x,y,LHC.colorFromLCH(90,c,l));
            }
        }
        WritableImage rainbow = new WritableImage(371,100);
        PixelWriter RainbowWriter = rainbow.getPixelWriter();
        for (int x =0; x<371; ++x){
            for (int y=0; y< 100; ++y){
                int wave = x + 380;
                RainbowWriter.setColor(x,y,WaveLengthToRGB.colorFromWave(wave));
            }
        }


        ImageView pic1 = new ImageView(favColor);
        ImageView pic2 = new ImageView(cordsRGB);
        ImageView pic3 = new ImageView(cordsHSB);
        ImageView pic4 = new ImageView(square);
        ImageView pic5 = new ImageView(circle);
        ImageView pic6 = new ImageView(cordsLHC);
        ImageView pic7 = new ImageView(rainbow);
        return new FlowPane(
                pic1,
                pic2,
                pic3,
                pic4,
                pic5,
                pic6,
                pic7
        );
    }
}
