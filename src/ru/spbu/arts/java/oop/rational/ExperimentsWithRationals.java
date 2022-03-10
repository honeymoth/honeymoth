package ru.spbu.arts.java.oop.rational;

import static ru.spbu.arts.java.oop.rational.Rational.*;

public class ExperimentsWithRationals {
    public static void main(String[] args){
        Rational test_1 = new Rational(5);
        Rational test_2 = new Rational(2,3);
        Rational test_3 = new Rational(2,4);
        Rational test_4 = new Rational(50,0);
        Rational test_5 = new Rational (-4,10);
        Rational test_6 = new Rational (2, -10);
        System.out.println(test_1);
        System.out.println(test_2);
        System.out.println(test_3);
        System.out.println(test_4);
        System.out.println(test_5);
        System.out.println(test_6);
        System.out.println(test_2.toDouble());
        System.out.println(test_3.toDouble());
        Rational sum = test_5.add(test_6);
        System.out.println(sum);
        Rational sub = test_5.sub(test_6);
        System.out.println(sub);
        Rational mul = test_5.mul(test_6);
        System.out.println(mul);
        Rational div = test_5.div(test_6);
        System.out.println(div);
        //test_5.addInPlace(test_6);
        //System.out.println(test_5);
        //test_5.subInPlace(test_6);
        //System.out.println(test_5);
        //test_5.mulInPlace(test_6);
        //System.out.println(test_5);
        //test_5.divInPlace(test_6);
        //System.out.println(test_5);
        Rational static_add = add(test_5,test_6);
        System.out.println(static_add);
        System.out.println(sub(test_5,test_6));
        System.out.println(mul(test_5,test_6));
        System.out.println(div(test_5,test_6));
    }
}
