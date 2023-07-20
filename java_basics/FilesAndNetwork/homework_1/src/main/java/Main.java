import java.util.Scanner;

public class Main {
    private static final char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите путь до папки: ");
            String input = scanner.nextLine().trim();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            if (FileUtils.calculateFolderSize(input) != 0) {
                System.out.println("Размер папки \"" + input + "\" составляет "
                        + convertFileSize(FileUtils.calculateFolderSize(input)));
            }
        }
    }

    public static String convertFileSize(long size) {
        for (int i = 0; i < sizeMultipliers.length; i++) {
            double value = ((double) size) / Math.pow(1024, i);
            if (value < 1024) {
                return Math.round(value * 100) / 100. + " " + sizeMultipliers[i] + (i > 0 ? "b" : "");
            }
        }
        return "Такого просто не может быть!!!";
    }
}
