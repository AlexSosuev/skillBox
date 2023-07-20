package practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер для поиска: ");
        String plateNumber = scanner.nextLine();
        List<String> list = new ArrayList<>(CoolNumbers.generateCoolNumbers());
        Collections.sort(list);
        HashSet<String> hashSet = new HashSet<>(list);
        TreeSet<String> treeSet = new TreeSet<>(list);
        long brutForce = System.nanoTime();
        String result = CoolNumbers.bruteForceSearchInList(list, plateNumber) ? "найден" : "не найден";
        System.out.printf("Поиск перебором: номер %s, поиск занял %d нс"
                + System.lineSeparator(), result, System.nanoTime() - brutForce);

        long binary = System.nanoTime();
        result = CoolNumbers.binarySearchInList(list, plateNumber) ? "найден" : "не найден";
        System.out.printf("Бинарный поиск: номер %s, поиск занял %d нс"
                + System.lineSeparator(), result, System.nanoTime() - binary);

        long hash = System.nanoTime();
        result = CoolNumbers.searchInHashSet(hashSet, plateNumber) ? "найден" : "не найден";
        System.out.printf("Поиск в HashSet: номер %s, поиск занял %d нс"
                + System.lineSeparator(), result, System.nanoTime() - hash);

        long tree = System.nanoTime();
        result = CoolNumbers.searchInTreeSet(treeSet, plateNumber) ? "найден" : "не найден";
        System.out.printf("Поиск в TreeSet: номер %s, поиск занял %d нс"
                + System.lineSeparator(), result, System.nanoTime() - tree);
    }
}