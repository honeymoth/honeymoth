package matrix_task;

public class matrix_test {
    public static void main(String[] args) {
        matrix2x2 num_matrix = new matrix2x2(1, 2, 3, 4);
        matrix2x2 matrix_sum = new matrix2x2(1, 1, 1,1);
        int [][] m = new int[][] {{1000, 7}, {42, 69}};
        matrix2x2 test_align = new matrix2x2(m);
        num_matrix.dis_footprint();
        test_align.print();
        num_matrix.print();
        num_matrix.add(matrix_sum);
        num_matrix.mul(matrix_sum);
        rotation trig = new rotation(45);
        System.out.println(trig.getAngle());

    }

}

