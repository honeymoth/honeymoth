package ru.spbu.arts.java.oop.ascigraphics;

public class ExperimentsWithDrawing {
    public static void main(String[] args) {
        Drawing plane = new Drawing(5,5,'.');
        plane.print();
        Drawing dote = new Drawing (4,4,'_');
        Drawing line = new Drawing(10,10,'0');
        dote.setPoint(3, 1, 'D');
        dote.print();
        line.drawVerticalLine(9,0,1, '|');
        line.drawHorizontalLine(9,0,2,'-');
        line.print();
        Drawing rectangle = new Drawing(20,10,'.');
        rectangle.drawRectangle(5,3,15,5,'X');
        System.out.println();
        rectangle.print();
        System.out.println();
        Drawing circle = new Drawing (20,20,'.');
        circle.drawCircle(9,9,4,'x');
        circle.print();
        Drawing displace = new Drawing (50,50,'.');
        displace.drawCircle(20,8,4,'X');
        displace.draw(21,10, circle.canvas);
        System.out.println();
        displace.print();

        System.out.println();
        Drawing heart = new Drawing(11,9,'.');
        heart.drawFilledCircle(3,3,1,'X');
        heart.drawFilledCircle(7,3,1,'X');
        heart.drawRectangle(4,4,6,5,'X');
        heart.setPoint(5,6,'X');
        heart.print();
    }
}
