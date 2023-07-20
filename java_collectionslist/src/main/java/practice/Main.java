package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TodoList list = new TodoList();
        System.out.println("Введите команду: ");
        while (true) {

            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();

            int index = 0;
            String str = "";

            String[] fullText = action.split("\\s+");
            String operation = fullText[0].toUpperCase();
            if (fullText.length != 1 && (operation.equals("ADD") || operation.equals("EDIT")
                    || operation.equals("DELETE"))) {
                if (fullText[1].matches("[0-9]+[\\.]?[0-9]*")) {
                    index = Integer.parseInt(fullText[1]);
                    for (int i = 2; i < fullText.length; i++) {
                        str = str.concat(fullText[i].concat(" "));
                    }
                } else {
                    for (int i = 1; i < fullText.length; i++) {
                        str = str.concat(fullText[i].concat(" "));
                    }
                }
                switch (operation) {
                    case "DELETE": list.delete(index);
                    case "EDIT": list.edit(index, str.trim());
                    case "ADD":
                        if (index == 0) {
                            list.add(str.trim());
                        } else {
                            list.add(index, str.trim());
                        }
                }
            } else if (operation.equals("LIST")) {
                list.getList();
            } else {
                System.out.println("Введена неизвестная или неполная команда! Повторите ввод");
            }
        }
    }
}

