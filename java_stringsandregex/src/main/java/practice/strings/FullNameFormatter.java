package practice.strings;

import java.util.Scanner;

public class FullNameFormatter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }

            int spaceCount = 0;
            String firstName = "";
            String secondName = "";
            String freeName = "";
            boolean log = true;

            for (int i = 0; i < input.length(); i++) {
                if (input.indexOf(" ") != -1 && Character.UnicodeBlock.of(input.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)
                        || input.charAt(i) == '-') {
                    firstName = input.substring(0, input.indexOf(" "));
                    secondName = input.substring(firstName.length(), input.lastIndexOf(" "));
                    freeName = input.substring(firstName.length() + secondName.length(), input.lastIndexOf(""));
                } else if (input.charAt(i) == ' ') {
                    spaceCount++;
                } else {
                    log = false;
                    break;
                }
            }

            if (!log || spaceCount != 2) {
                System.out.println("Введенная строка не является ФИО");
            } else {
                System.out.println("Фамилия: " + firstName.trim() + "\n" +
                                   "Имя: " + secondName.trim() + "\n" +
                                   "Отчество: " + freeName.trim());
            }
        }
    }
}