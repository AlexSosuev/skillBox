package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Mountain mountain = new Mountain("Кордильеры", 18000);
        mountain.setContinent("Северная Америка");
        mountain.setHighestPoint(6961);
        System.out.println(mountain.getName() + " находятся на континенте - " + mountain.getContinent() + ", их протяженность составляет "
            + mountain.getLength() + " км., самая высокая точка - " + mountain.getHighestPoint() + " км.");
    }
}
