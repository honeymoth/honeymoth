package ru.spbu.arts.java.oop.javafx.fractals;

import javafx.scene.paint.Color;

public class GradientCircle implements Fractal {
    @Override
    public Color paint(double x, double y) {
        double r = x * x + y * y;
        if (r > 1)
            r = 1;
        return Color.gray(r);
    }
}
