import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args) {
        int[] x = even(10);
        System.out.println(Arrays.toString(x));
        System.out.println(allSimilar(new int[]{1, 1, 1, 1, 1, 0}));
        System.out.println(hasSimilar(new int[]{1, 2, 3, 4, 6, 6}));
        System.out.println(mean(new int[]{1, 2, 3}));
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        shift(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(copyShift(new int[]{1, 2, 3, 4, 5, 6})));
        int[][] b = new int[][]{
                {-10, 1, 1000000, 44, 4244},
                {111, 423, 44},
                {5, 27, 1, 33, 123523, 6}
        };
        //printTable(b);
        printTableAligned(b);
        char[][] d = createTable(20, '.');
        fillFirstAndLastLines(d);
        fillFirstAndLastColumns(d);
        printTable(d);

    }

    private static int[] even(int n) {
        int[] a = new int[n];
        for (int i = 0; i != n; i++) {
            a[i] = (i + 1) * 2;
        }
        return a;
    }

    private static boolean allSimilar(int[] a) {
        for (int i = 0; i != a.length - 1; ++i) {
            if (a[i] != a[i + 1])
                return false;
        }
        return true;
    }

    private static boolean hasSimilar(int[] a) {
        for (int i = 0; i != a.length - 1; ++i) {
            for (int j = i + 1; j != a.length; ++j) {
                if (a[i] == a[j])
                    return true;
            }
        }
        return false;
    }

    private static double mean(int[] a) {
        double sum = 0;
        for (int i = 0; i != a.length; ++i) {
            sum = sum + a[i];
        }
        return sum / a.length;
    }

    private static void shift(int[] a) {
        int end;
        for (int i = a.length - 1; i != 0; i = i - 1) {
            end = a[i];
            a[i] = a[i - 1];
            a[i - 1] = end;
        }
    }

    private static int[] copyShift(int[] a) {
        int[] b = new int[a.length];
        b[a.length - 1] = a[0];
        for (int i = 0; i != a.length - 1; ++i) {
            b[i] = a[i + 1];
        }
        return b;
    }

    private static void printTable(int[][] a) {
        for (int i = 0; i != a.length; ++i) {
            for (int j = 0; j != a[i].length; ++j) {
                System.out.print("  " + a[i][j]);
            }
            System.out.println();
        }
    }

    private static void printTableAligned(int[][] a) {
        int max = 0;
        for (int i = 0; i != a.length; ++i) {
            if (a[i].length > max) {
                max = a[i].length;
            }
        }
        int[][] n = new int[a.length][max];
        int[] m = new int[max];
        for (int i = 0; i != a.length; ++i) {
            for (int j = 0; j != a[i].length; ++j) {
                int x = a[i][j];
                String num = "" + x;
                n[i][j] = num.length();
                if (n[i][j] > m[j]) {
                    m[j] = n[i][j];
                }
            }
        }
        for (int i = 0; i != a.length; ++i) {
            for (int j = 0; j != a[i].length; ++j) {
                for (int x = 0; x < m[j] - n[i][j]; ++x) {
                    System.out.print(" ");
                }
                System.out.print("  " + a[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] createTable(int n, char a) {
        char[][] x = new char[n][n];
        for (int i = 0; i != n; ++i) {
            for (int j = 0; j != n; ++j) {
                x[i][j] = a;
            }
        }
        return x;
    }

    private static void printTable(char[][] a) {
        for (int i = 0; i != a.length; ++i) {
            for (int j = 0; j != a.length; ++j) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillFirstAndLastLines(char[][] a) {
        char x = '#';
        Arrays.fill(a[0], x);
        Arrays.fill(a[a.length - 1], x);
    }

    private static void fillFirstAndLastColumns(char[][] a) {
        char x = '#';
        for (int i = 0; i != a.length; ++i) {
            a[i][0] = x;
            a[i][a.length - 1] = x;
        }
    }
}

