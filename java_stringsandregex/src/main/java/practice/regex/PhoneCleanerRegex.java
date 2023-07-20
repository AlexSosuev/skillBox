package practice.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCleanerRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }

            Pattern phone = Pattern.compile("^[78]?(9\\d{9})$");
            Pattern phoneClear = Pattern.compile("\\D");

            String correctPhone = phoneClear.matcher(input).replaceAll("");
            Matcher matcher = phone.matcher(correctPhone);
            System.out.println(matcher.find() ? "7".concat(matcher.group(1)) : "Неверный формат номера");
        }
    }
}
