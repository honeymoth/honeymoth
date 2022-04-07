package ru.spbu.arts.java.oop.lambdas;

public class PrintableLetter implements Printable {

    public char[][] table;


    public PrintableLetter(String a, int n) {
        this.table = new char[1][n];
        for (int i = 0; i != n; ++i) {
            this.table[0][i] = a.charAt(0);
        }
    }

    @Override
    public char[][] stroka() {
        return table;
    }
}
