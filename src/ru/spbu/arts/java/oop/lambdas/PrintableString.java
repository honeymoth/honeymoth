package ru.spbu.arts.java.oop.lambdas;

public class PrintableString implements Printable {
    public char[][] table;

    public PrintableString(String s) {
        this.table = new char[1][];
        table[0] = s.toCharArray();
    }

    @Override
    public char[][] stroka() {
        return table;
    }
}
