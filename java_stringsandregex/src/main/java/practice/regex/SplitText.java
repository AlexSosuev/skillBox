package practice.regex;

public class SplitText {
    public static void main(String[] args) {
        System.out.println(splitTextIntoWords("Вася   заработал   asdfas afdasd fadsf aads 5000 рублей, Петя - 756 рубля, а Маша - 30000 рублей."));
    }

    public static String splitTextIntoWords(String text) {
        return text.replaceAll("[\\s,\\d.;-]+", "\n").trim();
    }
}