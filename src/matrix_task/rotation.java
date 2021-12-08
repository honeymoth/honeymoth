package matrix_task;

public class rotation extends matrix2x2 {
    int angle;

    public rotation(int a) {
        super(a);
        this.angle = a;
    }

    public int getAngle() {
        return angle;
    }
}
