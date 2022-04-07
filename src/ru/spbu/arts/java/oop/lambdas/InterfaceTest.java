package ru.spbu.arts.java.oop.lambdas;

import java.util.Arrays;

public class InterfaceTest {
    public static void main(String[] args){
        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print();
        Drawing plane = new Drawing(5,5,'.');
        plane.print();
        Drawing dote = new Drawing(4,4,'_');
        dote.print();
        PrintableString ps = new PrintableString("asdf");
        ps.print();
        plane.setPoint(1,1,'*');
        plane.drawRectangle(0,0,3,3,'+');
        plane.print();

        Printable anon = new Printable(){
            @Override
            public char[][] stroka(){
                char[][] a = new char[5][5];
                Arrays.fill(a[0], '?');
                return a;
            }
        };

        Printable lambda = () -> {char[][] a = new char[2][2];
            Arrays.fill(a[0], '&');
        return a;};
        Printable[] a = new Printable[]{new PrintableLetter("a",10), new PrintableString("cool"), new Drawing(8,8,'-'), anon,  lambda};
        for (int i =0; i != a.length; ++i){
            a[i].print();
        }
    }
}
