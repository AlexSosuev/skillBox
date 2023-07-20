package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        int i = 0;
        StringBuilder previousBirthdays = new StringBuilder();
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE").localizedBy(Locale.US);

        while (birthday.isBefore(today) || birthday.isEqual(today)) {
            previousBirthdays.append(i++).append(" - ").append(birthday.format(formatter))
                             .append(System.lineSeparator());
            birthday = birthday.plusYears(1);
        }
        return previousBirthdays.toString();
    }
}
