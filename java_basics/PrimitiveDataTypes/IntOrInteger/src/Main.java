public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println("Результат первого задания: " + container.getCount() + "\n");

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.


        for (int i = 0; i < Character.MAX_VALUE; i++) {
            if ((char) i >= 'А' && (char) i <= 'я' || (char) i == 'Ё' || (char) i == 'ё') {
                System.out.println(i + " - " + (char) i);
            }
        }
    }
}
