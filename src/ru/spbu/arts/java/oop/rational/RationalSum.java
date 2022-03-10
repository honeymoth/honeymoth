package ru.spbu.arts.java.oop.rational;

public class RationalSum {
    public static void main(String[] args) {
        System.out.println(sumCounter(1));
        System.out.println(sumCounter(2));
        System.out.println(sumCounter(3));
        System.out.println(sumCounter(20));
    }

    public static double sumCounter(int n) {
        double sum = 0;
        double div;
        for (int i = 1; i != n + 1; ++i) {
            div = i;
            sum = sum + 1 / div;
        }
        return sum;
    }
}
