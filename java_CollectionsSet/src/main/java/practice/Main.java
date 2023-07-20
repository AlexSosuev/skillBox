package practice;

import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат e-mail";

    public static void main(String[] args) {
        EmailList email = new EmailList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            if (input.toUpperCase().trim().equals("LIST")) {
                email.getSortedEmails();
            } else {
                String operation = input.substring(0, input.indexOf(" ")).toUpperCase().trim();
                if (operation.equals("ADD")) {
                    String eMail = input.substring(input.indexOf(" ")).trim();
                    email.add(eMail);
                } else {
                    System.out.println(WRONG_EMAIL_ANSWER);
                }
            }
        }
    }
}

