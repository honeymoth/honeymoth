package ru.spbu.arts.java.oop.rational;

public class Rational {
    private int n;
    private int d;


    public Rational(int a, int b) {
        int num;
        int div;
        if (a < 0) {
            num = a * -1;
        } else {
            num = a;
        }
        if (b < 0) {
            div = b * -1;
        } else {
            div = b;
        }
        while (num != 0 && div != 0) {
            if (num > div) {
                num = num % div;
            } else {
                div = div % num;
            }
        }
        this.n = a / (num + div);
        this.d = b / (num + div);
    }

    public Rational(int a) {
        this.n = a;
        this.d = 1;
    }

    public String toString() {
        if (this.d == 1 | this.n == 0) {
            return Integer.toString(this.n);
        }
        if (this.d == 0) {
            return "error, can't divide by zero";
        }
        if (this.d < 0){
            this.d = this.d *-1;
            this.n = this.n*-1;
        }
        return this.n + "/" + this.d;
    }

    public double toDouble() {
        double num = this.n;
        double div = this.d;
        return num / div;
    }

    public int getN() {
        return this.n;
    }

    public int getD() {
        return this.d;
    }

    public Rational add(Rational x) {
        int num = this.n * x.d + x.n * this.d;
        int div = this.d * x.d;
        return new Rational(num, div);
    }

    public Rational sub(Rational x) {
        int num = this.n * x.d - x.n * this.d;
        int div = this.d * x.d;
        return new Rational(num, div);
    }

    public Rational mul(Rational x) {
        int num = this.n * x.n;
        int div = this.d * x.d;
        return new Rational(num, div);
    }

    public Rational div(Rational x) {
        int num = this.n * x.d;
        int div = this.d * x.n;
        return new Rational(num, div);
    }

    public static int NOD(int a, int b) {
        int num;
        int div;
        if (a < 0) {
            num = a * -1;
        } else {
            num = a;
        }
        if (b < 0) {
            div = b * -1;
        } else {
            div = b;
        }
        while (num != 0 && div != 0) {
            if (num > div) {
                num = num % div;
            } else {
                div = div % num;
            }
        }
        return div + num;
    }

    static Rational add(Rational x, Rational y) {
        int num = y.n * x.d + x.n * y.d;
        int div = y.d * x.d;
        return new Rational(num, div);
    }

    static Rational sub(Rational x, Rational y) {
        int num = y.n * x.d - x.n * y.d;
        int div = y.d * x.d;
        return new Rational(num, div);
    }

    static Rational mul(Rational x, Rational y) {
        int num = y.n * x.n;
        int div = y.d * x.d;
        return new Rational(num, div);
    }

    static Rational div(Rational x, Rational y) {
        int num = y.n * x.d;
        int div = y.d * x.n;
        return new Rational(num, div);
    }

    //public void addInPlace(Rational x) {
       // this.n = this.n * x.d + x.n * this.d;
       // this.d = this.d * x.d;
       // int n = NOD(this.n, this.d);
       // this.n = this.n / n;
       // this.d = this.d / n;
    //}

   // public void subInPlace(Rational x) {
       // this.n = this.n * x.d - x.n * this.d;
       // this.d = this.d * x.d;
       // int n = NOD(this.n, this.d);
       // this.n = this.n / n;
       // this.d = this.d / n;
    //}

    //public void mulInPlace(Rational x) {
        //this.n = this.n * x.n;
        //this.d = this.d * x.d;
        //int n = NOD(this.n, this.d);
        //this.n = this.n / n;
        //this.d = this.d / n;
    //}
    //public void divInPlace(Rational x) {
        //this.n = this.n * x.d;
        //this.d = this.d * x.n;
        //int n = NOD(this.n, this.d);
        //this.n = this.n / n;
        //this.d = this.d / n;
    //}


}
