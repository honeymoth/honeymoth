package ru.spbu.arts.java.oop.javafx.fractals;

import javafx.scene.paint.Color;

public class Mandelbrot implements Fractal {
    @Override
    public Color paint(double x, double y) {
        double zx = 0;
        double zy = 0;
        int R = 1000000;
        int step = 0;
        while (step < 1000 && Math.sqrt(zx * zx + zy * zy) < R) {
            double zx2 = zx * zx;
            double zy2 = zy * zy;
            double zxy = zy * zx;
            zx = zx2 - zy2 + x;
            zy = 2 * zxy + y;
            step = step + 1;

        }
        if (step == 1000) {
            return Color.gray(1);
        } else {
            return Color.gray(step / 1000.0);
        }
    }
}
