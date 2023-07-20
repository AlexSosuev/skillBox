package practice;

import java.util.*;

public class PhoneBook {
    Map<String, String> contact = new HashMap<>();

    public void addContact(String phone, String name) {
        if (phone.matches(Main.PHONE_REGEX) && name.matches(Main.NAME_REGEX)) {
            contact.put(phone, name);
        }
    }

    public String getContactByPhone(String phone) {
        if (contact.get(phone) != null) {
            return contact.get(phone) + " - " + phone;
        }
        return "";
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contactByName = new TreeSet<>();
        for (Map.Entry<String, String> entry : contact.entrySet()) {
            if (entry.getValue().equals(name)) {
                String contact = entry.getValue() + " - " + entry.getKey();
                contactByName.add(contact);
            }
        }
        return contactByName;
    }

    public Set<String> getAllContacts() {
        TreeSet<String> allContacts = new TreeSet<>();
        HashMap<String, String> map = new HashMap<>();

        for (Map.Entry<String, String> entry : contact.entrySet()) {
            String value = entry.getValue();
            map.merge(value, entry.getKey(), (a, b) -> a + ", " + b);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            allContacts.add(entry.getKey() + " - " + entry.getValue());
            System.out.println(entry.getKey() + " - " + entry.getValue() + "\n");
        }
        return allContacts;
    }
}