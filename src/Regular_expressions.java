import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_expressions {
    public static void main(String[] args) {
        System.out.println("email_1: " + Email_check_1("moth@gmail.com"));
        System.out.println("email_1: " + Email_check_1("something"));
        System.out.println("email_2: " + Email_check_2("moth_@gmail.com"));
        System.out.println("email_2: " + Email_check_2("moth-from-honey@gmail.com"));
        System.out.println("email_2: " + Email_check_2("moth8@gmail.com"));
        System.out.println("email_3: " + Email_check_ultimate("mothfromhoney@gmail.com"));
        System.out.println("email_3: " + Email_check_ultimate("moth@.ru"));
        String text = "we played from 18:00 to 20:46";
        Time_in_text(text);
        String test_space = "Это строка   , у которой зачем-то написаны два пробела перед запятой";
        space_correction(test_space);
        String test_hyphen = "Какая-то сине-зеленовая трава";
        shift_places(test_hyphen);
    }

    private static boolean Email_check_1(String a) {
        Pattern email = Pattern.compile("[A-Za-z]++@+[a-z]++\\.+[a-z]{2,4}");
        Matcher m = email.matcher(a);
        boolean result;
        result = m.matches();
        return result;
    }

    private static boolean Email_check_2(String a) {
        Pattern email = Pattern.compile("[A-Za-z_0-9-]++@+[a-z]++\\.+[a-z]{2,4}");
        Matcher m = email.matcher(a);
        boolean result;
        result = m.matches();
        return result;
    }

    private static boolean Email_check_ultimate(String a) {
        Pattern email = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\\\])");
        Matcher m = email.matcher(a);
        boolean result;
        result = m.matches();
        return result;
    }

    private static void Time_in_text(String t) {
        Pattern time_check = Pattern.compile("\\d\\d:\\d\\d");
        Matcher m = time_check.matcher(t);
        String time;
        String minutes_check;
        String first_hour_check;
        String second_hour_check;
        while (m.find()) {
            time = m.group();
            first_hour_check = time.substring(0, 1);
            second_hour_check = time.substring(1, 2);
            minutes_check = time.substring(3, 4);
            if (first_hour_check.matches("[0-2]") && minutes_check.matches("[0-6]")) {
                if (first_hour_check.matches("2") && second_hour_check.matches("[4-9]")) {
                    System.out.println(time + " - incorrect");
                } else {
                    System.out.println(time + " - correct");
                }
            } else {
                System.out.println(time + " - incorrect");
            }
        }
    }

    private static void space_correction(String text) {
        System.out.println(text.replaceAll("  *,", ","));
    }

    private static void shift_places(String text) {
        System.out.println(text.replaceAll("([\\u0410-\\u044fa-zA-Z0-9]+)-([\\u0410-\\u044fa-zA-Z0-9]+)", "$2-$1"));
    }


}
