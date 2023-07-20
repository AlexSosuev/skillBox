import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {

        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");


        if (components.length != 4) {
            throw new IllegalArgumentException("Не корректный ввод данных");
        } else {
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            Pattern pattern1 = Pattern.compile("[a-zA-Z-_]+@[a-zA-Z-_]+\\.[a-zA-Z]{2,3}");
            Matcher matcher1 = pattern1.matcher(components[INDEX_EMAIL]);
            Pattern pattern2 = Pattern.compile("^\\+[7][9][\\d]{9}");
            Matcher matcher2 = pattern2.matcher(components[INDEX_PHONE]);
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
            if (!matcher1.find()) {
                throw new IllegalArgumentException("Введен неверный формат электронной почты");
            } else if (!matcher2.find()) {
                throw new IllegalArgumentException("Введен неверный формат телефона");
            }
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}