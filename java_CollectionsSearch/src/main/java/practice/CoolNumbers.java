package practice;

import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        ArrayList<String> numbersList = new ArrayList<>();
        Character[] letters = new Character[]{'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        String beautifulNumber = "";

        for (Character firstLetter : letters) {
            for (int i = 1; i < 10; i++) {
                for (Character secondLetter : letters) {
                    for (Character thirdLetter : letters) {
                        for (int region = 1; region <= 199; region++) {
                            if (region < 10) {
                                beautifulNumber = String.format("%c%d%d%d%c%c0%d",
                                        firstLetter, i, i, i, secondLetter, thirdLetter, region);
                            } else {
                                beautifulNumber = String.format("%c%d%d%d%c%c%d",
                                        firstLetter, i, i, i, secondLetter, thirdLetter, region);
                            }
                            numbersList.add(beautifulNumber);
                        }
                    }
                }
            }
        }
        return numbersList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
