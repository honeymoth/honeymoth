package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {
    public static void main(String[] args) {
        Time clock_1 = new Time(22, 20);
        Time clock_2 = new Time(0, 10);
        Time clock_3 = new Time(4, 20);
        System.out.println(clock_1.show());
        System.out.println(clock_1.isMorning());
        System.out.println(clock_1.isDay());
        System.out.println(clock_1.isEvening());
        System.out.println(clock_1.isNight());
        System.out.println(clock_1.sayHello());
        System.out.println(clock_3.sayHello());
        System.out.println(clock_2.sayHello());
        clock_1.add(120);
        clock_3.add(360);
    }
}
