package practice;

import java.util.ArrayList;

public class TodoList {
    ArrayList<String> list = new ArrayList<>();


    public void add(String todo) {
        list.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void add(int index, String todo) {
        if (index < list.size()) {
            System.out.println("Добавлено дело \"" + todo + "\" под номером " + index);
            list.add(index, todo);
        } else {
            System.out.println("Добавлено дело \"" + todo + "\" в конец списка.");
            list.add(todo);
        }
    }

    public void edit(int index, String todo) {
        if (index < list.size()) {
            System.out.println("Дело \"" + list.get(index) + "\" заменено на \"" + todo + "\"");
            list.set(index, todo);
        }
    }

    public void delete(int index) {
        if (index < list.size()) {
            System.out.println("Дело \"" + list.get(index) + "\" удалено");
            list.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
        list.trimToSize();
    }

    public void getList() {
        if (list.size() == 0) {
            System.out.println("Список пуст");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + " - " + list.get(i));
            }
        }
    }

    public ArrayList<String> getTodos() {
        return list;
    }
}