package ru.spbu.arts.java.oop.time;


public class Time {
    int Hours;
    int Minutes;

    public Time(int x, int y) {
        if (x > 23 | y > 59) {
            System.out.println("Неозможное время");
        } else {
            this.Hours = x;
            this.Minutes = y;
        }
    }

    public String show() {
        return this.Hours + ":" + this.Minutes;
    }

    public boolean isMorning() {
        return this.Hours > 3 && this.Hours < 13;
    }

    public boolean isDay() {
        return this.Hours > 12 && this.Hours < 17;
    }

    public boolean isEvening() {
        return this.Hours > 16 && this.Hours < 24;
    }

    public boolean isNight() {
        return this.Hours >= 0 && this.Hours < 4;
    }

    public String sayHello() {
        String str = "";
        if (isMorning()) {
            str = "Доброе утро))";
        }
        if (isDay()) {
            str = "Добрый день :)";
        }
        if (isEvening()) {
            str = "Добрый вечер)))";
        }
        if (isNight()) {
            str = "Доброй ночи :]";
        }
        return str;
    }

    void add(int a) {
        int new_min = this.Minutes + a;
        int new_hours = this.Hours;
        while (new_min > 59) {
            new_min = new_min - 60;
            new_hours = new_hours + 1;
            if (new_hours == 24) {
                new_hours = 0;
            }
        }
        System.out.println(new_hours + ":" + new_min);
    }
}