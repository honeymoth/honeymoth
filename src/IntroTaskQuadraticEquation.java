public class IntroTaskQuadraticEquation {
    public static void main(String[] args){
        double a = 0;
        double b = 2;
        double c = 2;
        double x = 0;
        double x1 = 0;
        double x2 = 0;
        double d = 0;
        if (a == 0 ){
            if (b == 0){
                if (c == 0){
                    System.out.println("решений бесконечно много");
                }else{
                    System.out.println("нет решений");
                }
            }else{
                if (c == 0){
                    System.out.println("x = 0,00");
                }else{
                    x = -c/b ;
                    System.out.printf("x = " + "%.2f",x );
                }
            }
        }else{
            if (b == 0){
                if (c == 0){
                    System.out.println("x = 0,00");
                }else{
                    if (-c/a < 0){
                        System.out.println("нет решений");
                    }else {
                        x1 = Math.sqrt(-c / a);
                        x2 = -1 * Math.sqrt(-c / a);
                        System.out.printf("x_1 = " + "%.2f", x1);
                        System.out.printf(" x_2 = " + "%.2f", x2);
                    }
                }
            }else{
                if (c == 0){
                    x1 = 0;
                    x2 = -b/a;
                    System.out.printf("x_1 = "+ "%.2f",x1);
                    System.out.printf(" x_2 = " + "%.2f",x2);
                }else{
                    d = b*b - 4*a*c;
                    if (d < 0){
                        System.out.println("нет решений");
                    }else{
                        if (d > 0){
                            x1 = (-b + Math.sqrt(d))/(2*a);
                            x2 = (-b - Math.sqrt(d))/(2*a);
                            System.out.printf("x_1 = "+ "%.2f",x1);
                            System.out.printf(" x_2 = " + "%.2f",x2);
                        }else{
                            x = -b/(2*a);
                            System.out.printf("x = " + "%.2f",x);
                        }
                    }
                }
            }
        }
    }
}
