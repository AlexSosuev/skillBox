package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    TreeSet<String> eMailList = new TreeSet<>();

    public void add(String eMail) {
        String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(eMail.toLowerCase());
        if (matcher.find()) {
            eMailList.add(eMail.toLowerCase());
        } else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        if (eMailList.size() == 0) {
            System.out.println("Список пуст");
        } else {
            for (String email : eMailList) {
                System.out.println(email);
            }
        }
        return new ArrayList<>(eMailList);
    }
}