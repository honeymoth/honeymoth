package matrix_task;


import java.util.Arrays;

public class matrix2x2 {
    int[][] int_matrix;
    String[][] str_matrix;


    public matrix2x2(int a, int b, int c, int d) {
        this.int_matrix = new int[][]{{a, b}, {c, d}};
    }

    public matrix2x2(int[][] matrix) {
        this.int_matrix = matrix;
    }

    void dis_footprint(int[][] matrix) {
        int footprint = matrix[0][0] + matrix[1][1];
        int discriminant = matrix[0][0] * matrix[1][1] + matrix[0][1] * matrix[1][0];
        System.out.println("matrix footprint = " + footprint);
        System.out.println("matrix discriminant = " + discriminant);
    }

    public int[][] getInt_matrix() {
        return this.int_matrix;
    }

    public String toString(int[][] matrix) {
        String str ="";
        for (int i =0; i != matrix.length; ++i){
           str = str +" "+ Arrays.toString(matrix[i]);
        }
        return str;
    }

    void print(int[][] matrix) {
        int max = 0;
        for (int i = 0; i != matrix.length; ++i) {
            if (matrix[i].length > max) {
                max = matrix[i].length;
            }
        }
        int[][] n = new int[matrix.length][max];
        int[] m = new int[max];
        for (int i = 0; i != matrix.length; ++i) {
            for (int j = 0; j != matrix[i].length; ++j) {
                int x = matrix[i][j];
                String num = "" + x;
                n[i][j] = num.length();
                if (n[i][j] > m[j]) {
                    m[j] = n[i][j];
                }
            }
        }
        for (int i = 0; i != matrix.length; ++i) {
            for (int j = 0; j != matrix[i].length; ++j) {
                for (int x = 0; x < m[j] - n[i][j]; ++x) {
                    System.out.print(" ");
                }
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}


