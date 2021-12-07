package matrix_task;

public class matrix_test {
    public static void main(String[] args) {
        matrix2x2 num_matrix = new matrix2x2(1, 2, 3, 4);
        int [][] m = new int[][] {{1000, 7}, {42, 69}};
        matrix2x2 test_align = new matrix2x2(m);
        num_matrix.dis_footprint(num_matrix.int_matrix);
        System.out.println(test_align.toString(test_align.getInt_matrix()));
        test_align.print(test_align.int_matrix);
        num_matrix.print(num_matrix.int_matrix);
    }

}

