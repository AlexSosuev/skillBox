package practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalEarningsCalculatorRegex {

    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 756 рубля, а Маша - 30000 рублей";
        System.out.println(calculateSalarySum(text));
    }

    public static int calculateSalarySum(String text) {
        int sum = 0;
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            sum += Integer.parseInt(text.substring(start, end));
        }
        return sum;
    }
}