package practice;

import java.time.LocalDate;
import java.time.Period;

public class Periods {


    // реализуйте вывод разницы между датами, используя класс Period
    public static String getPeriodFromBirthday(LocalDate firstDate, LocalDate secondDate) {
        Period p = Period.between(firstDate, secondDate);
        return "years:" + p.getYears() + ", months:" + p.getMonths() + ", days:" + p.getDays();
    }
}
