import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args){
        int[] x = even(10);
        System.out.println(Arrays.toString(x));
        System.out.println(allSimilar(new int[]{1, 1, 1, 1, 1, 0}));
        System.out.println(hasSimilar(new int[]{1, 2, 3, 4, 6, 6}));
        System.out.println(mean(new int[]{1, 2, 3}));
        int [] a = {1, 2, 3, 4, 5, 6, 7, 8};
        shift(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(copyShift(new int[]{1, 2, 3, 4, 5, 6})));
    }

    private static int[] even(int n) {
        int[] a = new int[n];
        for (int i = 0; i != n; i++ ){
            a [i] = (i+1) * 2;
        }
        return a;
    }

    private static boolean allSimilar(int[] a) {
        for (int i = 0; i != a.length-1; ++i) {
            if (a[i] != a[i + 1])
                return false;
        }
        return true;
    }

    private static boolean hasSimilar(int[] a){
        for (int i = 0; i != a.length-1; ++i) {
            for (int j = i + 1; j != a.length; ++j){
                if (a[i] == a[j])
                    return true;
            }
        }
        return false;
    }

    private static double mean(int[] a){
        double sum = 0;
        for (int i = 0; i != a.length; ++i) {
            sum = sum + a[i];
        }
        return sum/a.length;
    }

    private static void shift(int[] a){
        int end = a[0];
        for (int i = a.length - 1; i != 0; i = i - 1){
            end = a[i];
            a[i] = a[i-1];
            a[i-1] = end;
        }
    }

    private static int[] copyShift(int[] a){
        int [] b = new int[a.length];
        b[a.length-1] = a[0];
        for (int i =0; i!=a.length-1; ++i){
            b[i] = a[i+1];
        }
        return b;
    }
}

