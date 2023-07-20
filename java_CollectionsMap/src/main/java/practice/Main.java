package practice;

import java.util.Scanner;

public class Main {
    public static final String PHONE_REGEX = "79[\\d]{9}";
    public static final String NAME_REGEX = "[А-Яа-яЁё]+";
    private static Scanner scanner = new Scanner(System.in);
    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        while (true) {
            System.out.println("Введите номер, имя или команду: ");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            if (input.toUpperCase().equals("LIST")) {
                phoneBook.getAllContacts();
            } else if (input.matches(PHONE_REGEX)) {
                byPhone(input);
            } else if (input.matches(NAME_REGEX)) {
                byName(input);
            } else {
                System.out.println("Неверный формат ввода" + "\n");
            }
        }
    }

    private static void byPhone(String phone) {
        if (phoneBook.getContactByPhone(phone).isEmpty()) {
            System.out.println("Такого номера нет в телефонной книге. " + "\n" +
                    "Введите имя абонента для номера “" + phone + "”:");
            String name = scanner.nextLine();
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            if (name.matches(Main.NAME_REGEX)) {
                phoneBook.addContact(phone, name);
                System.out.println("Контакт сохранен!" + "\n");
            } else {
                System.out.println("Неверный формат ввода, контакт не сохранен" + "\n");
            }
        } else {
            System.out.println("Данный номер уже есть в базе у анонента ”"
                    + phoneBook.contact.get(phone) + "”.\n");
        }
    }

    private static void byName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        if (phoneBook.getContactByName(name).isEmpty()) {
            System.out.println("Такого имени в телефонной книге нет. " + "\n" +
                    "Введите номер телефона для абонента “" + name + "”:");
            String phone = scanner.nextLine();
            if (phone.matches(Main.PHONE_REGEX)) {
                phoneBook.addContact(phone, name);
                System.out.println("Контакт сохранен!" + "\n");
            } else {
                System.out.println("Неверный формат ввода, контакт не сохранен" + "\n");
            }
        } else {
            System.out.println("Абонент “" + name + "” уже есть в базе с номером(ами): "
                    + phoneBook.getContactByName(name).toString()
                    .replaceAll("[-\\s\\[\\]А-Яа-яЁё]", "") + "\n");
        }
    }
}
