package oldTasks;

public class IntroTaskLeap {
    public static void main(String[] args){
        int year = 2021;
        if (year %  400 == 0){
            System.out.println(year +" - високосный");
        }else{
            if (year % 100 != 0 && year % 4 == 0){
                System.out.println(year +" - високосный");
            }else{
                System.out.println(year +" - не високосный");
            }
        }
    }
}
