package ru.spbu.arts.java.oop.lambdas;

public interface Printable {
    char[][] stroka();

    default void print() {
        for (int i = 0; i != stroka().length; ++i) {
            for (int j = 0; j != stroka()[i].length; ++j) {
                System.out.print(stroka()[i][j]);
            }
            System.out.println();
        }
    }
}
