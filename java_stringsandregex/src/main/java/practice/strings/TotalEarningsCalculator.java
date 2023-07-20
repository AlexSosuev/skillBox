package practice.strings;

public class TotalEarningsCalculator {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль

        String str = "";
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                str += text.charAt(i);
            } else {
                if (!str.equals("")) {
                    sum += Integer.parseInt(str);
                    str = "";
                }
            }
        }
        System.out.println(sum);
    }
}