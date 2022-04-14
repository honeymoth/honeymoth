package oldTasks;

public class IntroTaskSameDigits {
    public static void main(String[] args){
        int x =120;
        if (x > 9 && x% 10 == (x / 10)%10){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
