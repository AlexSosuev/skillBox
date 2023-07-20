import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите папку, которую нужно копировать: ");
        String dirOne = scanner.nextLine().trim();
        System.out.println("Введите папку, в которую нужно копировать: ");
        String dirTwo = scanner.nextLine().trim();
        FileUtils.copyFolder(dirOne, dirTwo);
    }
}