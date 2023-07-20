package practice.regex;

import java.util.Scanner;
public class FullNameFormatterRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("0")) {
                scanner.close();
                break;
            }

            String[] str = input.split("\\s+");
            String regex = "^([А-яЁё-]+\\s*){3}$";
            if (input.matches(regex) && str.length == 3){
                System.out.println("Фамилия: " + str[0].replaceAll("-+", "-") + System.lineSeparator() +
                                   "Имя: " + str[1].replaceAll("-+", "-") + System.lineSeparator() +
                                   "Отчество: " + str[2].replaceAll("-+", "-"));
            }else {
                System.out.println("Введенная строка не является ФИО");
            }
        }
    }
}