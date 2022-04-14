package oldTasks;

public class IntroTaskCat {
    public static void main(String[] args){
        int cat = 2;
        if (cat % 10 == 1){
            System.out.println(cat + " кот");
        }else {
            if (cat % 10 >1 && cat % 10 <5){
                System.out.println(cat + " кота");
            }else {
                System.out.println(cat + " котов");
            }
        }
    }
}
